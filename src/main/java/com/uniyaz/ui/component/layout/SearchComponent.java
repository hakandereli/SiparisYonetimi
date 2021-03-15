package com.uniyaz.ui.component.layout;

import com.uniyaz.ui.MySiteUI;
import com.uniyaz.ui.page.UrunListePage;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

import javax.xml.soap.Text;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class SearchComponent extends HorizontalLayout {
    private HorizontalLayout mainLayout;
    private TextField searchField;
    private Button searchButton;
    private UrunListePage urunListePage;
    private ContentComponent contentComponent;

    public SearchComponent() {
        setSizeFull();

        buildSearchLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
    }

    private void buildSearchLayout() {
        mainLayout = new HorizontalLayout();

        searchField = new TextField();
        searchField.setId("searchField");
        searchField.setInputPrompt("Ürün adı girin");
        mainLayout.addComponents(searchField);

        searchButton = buildSearchButton();
        searchButton.setIcon(FontAwesome.SEARCH);
        mainLayout.addComponents(searchButton);
    }

    private Button buildSearchButton() {
        searchButton = new Button();
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MySiteUI mySiteUI = (MySiteUI) MySiteUI.getCurrent();
                contentComponent = mySiteUI.getContentComponent();
                urunListePage = new UrunListePage(searchField.getValue());
                contentComponent.setContent(urunListePage);
            }
        });
        return  searchButton;
    }
}

