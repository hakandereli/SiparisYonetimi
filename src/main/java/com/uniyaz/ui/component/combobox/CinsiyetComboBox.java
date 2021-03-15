package com.uniyaz.ui.component.combobox;

import com.uniyaz.core.enums.EnumCinsiyet;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

/**
 * @author HAKAN DERELİ
 * @since 5.xxx.x
 */
public class CinsiyetComboBox extends ComboBox {
    public CinsiyetComboBox(){
        fillComboBox();
    }

    private void fillComboBox() {
        for (EnumCinsiyet cinsiyet : EnumCinsiyet.values()) {
            Item item = addItem(cinsiyet);
        }
    }
}
