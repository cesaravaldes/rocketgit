package com.rocketgit.components;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.NamedArg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class IconMenuItem extends CustomMenuItem {
    public IconMenuItem(@NamedArg("icon") String iconName, @NamedArg("text") String text) {
        HBox content = new HBox();
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(0, 5, 0, 5));
        content.setSpacing(10);

        if (!iconName.isEmpty()) {
            FontAwesomeIconView icon = new FontAwesomeIconView();
            icon.setGlyphName(iconName);
            content.getChildren().add(icon);
        }

        if (!text.isEmpty()) {
            Label label = new Label(text);
            label.setStyle("-fx-text-fill: black;");
            content.getChildren().add(label);
        }

        this.setMnemonicParsing(false);
        this.setContent(content);
    }
}
