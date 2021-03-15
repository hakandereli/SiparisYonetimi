package com.uniyaz.ui.page;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;
import com.uniyaz.ui.component.button.MySaveButton;
import com.uniyaz.ui.component.combobox.CinsiyetComboBox;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MusteriPage extends VerticalLayout {
    @PropertyId("id")
    private TextField idTextField;

    @PropertyId("ad")
    private TextField adTextField;

    @PropertyId("cinsiyet")
    private CinsiyetComboBox cinsiyetCombofield;

//    @PropertyId("adres")
//    private String adresField;

    private FormLayout mainLayout;
    private BeanItem<Musteri> musteriBeanItem;
    private FieldGroup binder;
    private MySaveButton mySaveButton;

    public MusteriPage() {
        this(new Musteri());
    }
    public  MusteriPage(Musteri musteri){
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);
        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        musteriBeanItem = new BeanItem<Musteri>(musteri);
        binder = new FieldGroup(musteriBeanItem);
        binder.bindMemberFields(this);
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        mainLayout.setSizeUndefined();

        idTextField = new TextField();
        idTextField.setCaption("ID");
        mainLayout.addComponent(idTextField);

        adTextField = new TextField();
        adTextField.setCaption("Ad");
        mainLayout.addComponent(adTextField);

        cinsiyetCombofield = new CinsiyetComboBox();
        cinsiyetCombofield.setCaption("Cinsiyet");
        mainLayout.addComponent(cinsiyetCombofield);

        mySaveButton = new MySaveButton();
        mySaveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                try {
                    binder.commit();

                    Musteri musteri = musteriBeanItem.getBean();
                    MusteriService musteriService = new MusteriService();
                    musteriService.saveMusteri(musteri);
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Alanlar nesne ile uyumlu değil", Notification.Type.ERROR_MESSAGE);
                }catch (Exception e) {
                    Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        mainLayout.addComponent(mySaveButton);
    }


}
