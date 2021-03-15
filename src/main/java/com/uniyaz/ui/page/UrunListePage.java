package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.ui.MySiteUI;
import com.uniyaz.ui.component.layout.ContentComponent;
import com.uniyaz.ui.component.button.MyDeleteButton;
import com.uniyaz.ui.component.button.MyEditButton;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import com.vaadin.ui.Button;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class UrunListePage extends VerticalLayout {
    private VerticalLayout mainLayout;
    private Table table;
    private Container container;

    public UrunListePage(String filtre) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable(filtre);
    }

    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();

        builTable();
        mainLayout.addComponent(table);
    }

    private void builTable() {
        table = new Table();

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID","AD","KOD","FIYAT","","");
    }

    private void buildContainer() {

        container = new IndexedContainer();
        container.addContainerProperty("id",Long.class,null);
        container.addContainerProperty("ad",String.class,null);
        container.addContainerProperty("kod",String.class,null);
        container.addContainerProperty("fiyat", BigDecimal.class,null);
        container.addContainerProperty("guncelle", Button.class,null);
        container.addContainerProperty("sil",Button.class,null);
    }

    private void fillTable(String filtre) {
        UrunService  urunService = new UrunService();
        List<Urun> urunList = urunService.findAllHql(filtre);
        if (!filtre.equals("")){
            Notification.show(urunList.size() + " Kayıt Bulundu");
        }
        container.removeAllItems();
        for(Urun urun:urunList){
            Item item = container.addItem(urun);
            item.getItemProperty("id").setValue(urun.getId());
            item.getItemProperty("ad").setValue(urun.getAd());
            item.getItemProperty("kod").setValue(urun.getKod());
            item.getItemProperty("fiyat").setValue(urun.getFiyat());

            MyEditButton guncelle = builEditButton(urun);
            item.getItemProperty("guncelle").setValue(guncelle);

            MyDeleteButton sil = buildDeleteButton(urun);
            item.getItemProperty("sil").setValue(sil);
        }
    }

    private MyEditButton builEditButton(Urun urun) {
        MyEditButton myEditButton = new MyEditButton();
        myEditButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MySiteUI mySiteUI = (MySiteUI) MySiteUI.getCurrent();
                ContentComponent contentComponent = mySiteUI.getContentComponent();

                UrunPage urunPage = new UrunPage(urun);
                contentComponent.setContent(urunPage);
            }
        });
        return myEditButton;
    }

    private MyDeleteButton buildDeleteButton(Urun urun) {
        MyDeleteButton myDeleteButton = new MyDeleteButton();
        myDeleteButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    UrunService urunService = new UrunService();
                    urunService.deleteUrun(urun);
                    Notification.show("Silme Başarılı");
                }catch (Exception e){
                    Notification.show(e.getMessage());
                }

                fillTable("");
            }
        });
        return myDeleteButton;
    }

}
