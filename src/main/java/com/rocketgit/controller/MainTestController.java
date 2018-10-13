package com.rocketgit.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

import com.rocketgit.components.IconMenuItem;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainTestController {

    @FXML
    TreeView<String> treeViewRepoList;
    
    @FXML
    IconMenuItem config;
    
    @FXML
    BorderPane border_pane;

    @FXML
    public void initialize() {
        initRepoList();
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void openConfig(ActionEvent actionEvent)  {
    	FXMLLoader loader = new FXMLLoader();
    	 
    	ResourceBundle rb = ResourceBundle.getBundle(
    				"i18n.main",
    				new Locale.Builder().setLanguage("en").build()
    				);
    	loader.setResources(rb);
    	loader.setCharset(Charset.forName("UTF-8"));

    	try {
    		Font.loadFont(getClass().getClassLoader().getResource("Comfortaa-Regular.ttf").toExternalForm(), 13);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		System.exit(0);
    	}
    	try {
    		Parent root = loader.load(getClass().getClassLoader().getResource("config.fxml").openStream());

    		root.setStyle("-fx-font-family: 'Comfortaa';");
    		Scene scene = new Scene(root);
    		Stage app_stage = (Stage) border_pane.getScene().getWindow();
    	    //app_stage.hide(); //optional
    	    app_stage.setScene(scene);
    	    app_stage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    
    // TODO Remove dummy data
    private void initRepoList() {
        treeViewRepoList.setEditable(false);
        TreeItem<String> root = new TreeItem<>();
        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setGlyphName("GITHUB");
        root.setGraphic(icon);
        root.setValue("GitHub");
        for (int i = 0; i < 7; i++) {
            FontAwesomeIconView itemIcon = new FontAwesomeIconView();
            itemIcon.setGlyphName("BOOK");
            root.getChildren().add(new TreeItem<>("Repo " + i, itemIcon ));
        }
        root.setExpanded(true);
        treeViewRepoList.setRoot(root);
    }
}
