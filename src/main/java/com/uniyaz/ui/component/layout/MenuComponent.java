package com.uniyaz.ui.component.layout;

import com.uniyaz.ui.MySiteUI;
import com.uniyaz.ui.page.MusteriPage;
import com.uniyaz.ui.page.UrunListePage;
import com.uniyaz.ui.page.UrunPage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MenuComponent extends MenuBar {
    private ContentComponent contentComponent;

    public MenuComponent() {
        setSizeFull();
        addStyleName("MenuComponent");

        MySiteUI mySiteUI = (MySiteUI) UI.getCurrent();
        contentComponent = mySiteUI.getContentComponent();

        buildUrunİslemleriMenuItem();

        buildMusteriIslemleriMenuItem();
    }

    private void buildUrunİslemleriMenuItem() {
        MenuItem urunIslemleriMenuItem =  addItem("Ürün İşlemleri",null);
        urunIslemleriMenuItem.addItem("Ürün Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunPage urunPage = new UrunPage();
                contentComponent.setContent(urunPage);
            }
        });

        urunIslemleriMenuItem.addItem("Ürün Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UrunListePage urunListePage = new UrunListePage("");
                contentComponent.setContent(urunListePage);
            }
        });
    }


    private void buildMusteriIslemleriMenuItem() {
        MenuItem menuIslemleriMenuItem = addItem("Müşteri İişlemleri",null);
        menuIslemleriMenuItem.addItem("Müşteri Ekle", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                MusteriPage musteriPage = new MusteriPage();
                contentComponent.setContent(musteriPage);
            }
        });

        menuIslemleriMenuItem.addItem("Müşteri Listele", FontAwesome.LIST, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {

            }
        });
    }
}
