package com.rocketgit.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

import org.controlsfx.control.ToggleSwitch;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfigController {
	
	@FXML
    BorderPane border_pane;
	
	@FXML
	private Button config_branch_open;
	@FXML
	private Button config_diff_open;
	@FXML
	private Button config_decorate_open;
	@FXML
	private Button config_interactive_open;
	@FXML
	private Button config_status_open;
	
	@FXML
	private GridPane config_branch_grid;
	@FXML
	private GridPane config_diff_grid;
	@FXML
	private GridPane config_decorate_grid;
	@FXML
	private GridPane config_interactive_grid;
	@FXML
	private GridPane config_status_grid;
	
	@FXML
	private ChoiceBox<String> config_scope;
	
	@FXML
	private ToggleSwitch config_ui;
	
	@FXML
	TreeView<String> treeViewRepoList;

	@FXML
	public void initialize() {
		initRepoList();
	}

	public void exit(ActionEvent actionEvent) {
		Platform.exit();
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
	    
	    config_scope.getItems().addAll("Local", "Global", "System");
	    //config_ui.getItems().addAll(")
	    initGrid();
	}
	
	
	public void initGrid() {
		config_branch_grid.setVisible(false);
		config_branch_grid.managedProperty().bind(config_branch_grid.visibleProperty());
		
		config_diff_grid.setVisible(false);
		config_diff_grid.managedProperty().bind(config_diff_grid.visibleProperty());
		
		config_decorate_grid.setVisible(false);
		config_decorate_grid.managedProperty().bind(config_decorate_grid.visibleProperty());
		
		config_interactive_grid.setVisible(false);
		config_interactive_grid.managedProperty().bind(config_interactive_grid.visibleProperty());
		
		config_status_grid.setVisible(false);
		config_status_grid.managedProperty().bind(config_status_grid.visibleProperty());
	}

	@FXML
	private void collapseBranch(ActionEvent event) {
		collapseOrExpand(config_branch_open, config_branch_grid);	
	}
	
	@FXML
	private void collapseDecorate(ActionEvent event) {
		collapseOrExpand(config_decorate_open, config_decorate_grid);
	}
	
	@FXML
	private void collapseDiff(ActionEvent event) {
		collapseOrExpand(config_diff_open, config_diff_grid);
	}
	
	@FXML
	private void collapseInteractive(ActionEvent event) {
		collapseOrExpand(config_interactive_open, config_interactive_grid);
	}
	
	@FXML
	private void collapseStatus(ActionEvent event) {
		collapseOrExpand(config_status_open, config_status_grid);
	}

	private static void collapseOrExpand(Button btn, GridPane grid) {
		if(btn.getStyleClass().contains("show")) {
			btn.getStyleClass().remove("show");
			grid.setVisible(false);
			grid.managedProperty().bind(grid.visibleProperty());
			}
		else {
			btn.getStyleClass().add("show");
			grid.setVisible(true);
		}
	
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
}
