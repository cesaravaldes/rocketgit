package com.rocketgit.components;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.NamedArg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class IconMenuItem extends CustomMenuItem {

    private Label label;
    private FontAwesomeIconView icon;

    public IconMenuItem(@NamedArg("icon") String iconName, @NamedArg("text") String text) {
        HBox content = new HBox();
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(0, 5, 0, 5));
        content.setSpacing(10);

        if (!iconName.isEmpty()) {
            icon = new FontAwesomeIconView();
            icon.setGlyphName(iconName);
            content.getChildren().add(icon);
        }

        if (!text.isEmpty()) {
            label = new Label(text);
            label.setStyle("-fx-text-fill: black;");
            content.getChildren().add(label);
        }

        this.setMnemonicParsing(false);
        this.setContent(content);
    }

    public void setLabelText(String text) {
        this.label.setText(text);
    }

    public String getLabelText() {
        return this.label.getText();
    }

    public void setIconName(String name) {
        this.icon.setGlyphName(name);
    }

    public String getIconName() {
        return this.icon.getGlyphName();
    }
}
