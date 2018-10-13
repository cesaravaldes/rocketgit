package com.rocketgit.controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeController {

    @FXML
    TreeView<String> treeViewRepoList;

    @FXML
    public void initialize() {
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }


}