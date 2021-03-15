package com.uniyaz.ui.component.button;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class MySaveButton extends Button {
    public MySaveButton(){
        setIcon(FontAwesome.SAVE);
        addStyleName(ValoTheme.BUTTON_PRIMARY);
    }
}
