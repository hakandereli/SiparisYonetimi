package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Urun;
import com.uniyaz.core.service.UrunService;
import com.uniyaz.ui.component.button.MySaveButton;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class UrunPage extends VerticalLayout {

    @PropertyId("id")
    private TextField idField;

    @PropertyId("ad")
    private TextField adField;

    @PropertyId("kod")
    private TextField kodField;

    @PropertyId("fiyat")
    private TextField fiyatField;

    private FormLayout mainLayout;

    private BeanItem<Urun> urunBeanItem;
    private FieldGroup binder;
    private MySaveButton mySaveButton;

    public UrunPage(){
        this(new Urun());
    }

    public UrunPage(Urun urun) {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        urunBeanItem = new BeanItem<Urun>(urun);
        binder = new FieldGroup(urunBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        idField = new TextField();
        idField.setCaption("ID");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        adField = new TextField();
        adField.setCaption("AD");
        mainLayout.addComponent(adField);

        kodField = new TextField();
        kodField.setCaption("KOD");
        mainLayout.addComponent(kodField);

        fiyatField = new TextField();
        fiyatField.setCaption("FİYAT");
        mainLayout.addComponent(fiyatField);

        mySaveButton = new MySaveButton();
        mySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Urun urun = urunBeanItem.getBean();
                    UrunService urunService = new UrunService();
                    urunService.saveUrun(urun);
                    Notification.show(urun.getAd() + " Adlı Ürün Kaydedildi !");
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil",Notification.Type.ERROR_MESSAGE);
                }

            }
        });
        mainLayout.addComponent(mySaveButton);
    }
}
