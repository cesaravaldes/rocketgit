package com.rocketgit.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfigController {
	
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
	private void initialize(){
		/*chBxOptions.getItems().addAll("Celsius to Fahrenheit", "Fahrenheit to Celsius");
		chBxOptions.getSelectionModel().select(0);
		chBxOptions.setOnAction(event->convert());*/
	}

	@FXML
	private void clickBranch(ActionEvent event) {
		
		if(event.getSource().equals(config_branch_open)) {
			collapseOrExpand(config_branch_open, config_branch_grid);
			
		}
		
		if(event.getSource().equals(config_diff_open)) {
			collapseOrExpand(config_diff_open, config_diff_grid);
			
		}
		
		if(event.getSource().equals(config_decorate_open)) {
			collapseOrExpand(config_decorate_open, config_decorate_grid);
		}
		
		if(event.getSource().equals(config_interactive_open)) {
			collapseOrExpand(config_interactive_open, config_interactive_grid);
			
		}
		
		if(event.getSource().equals(config_status_open)) {
			collapseOrExpand(config_status_open, config_status_grid);
			
		}
		
		
	}

	private static void collapseOrExpand(Button btn, GridPane grid) {
		if(btn.getStyleClass().contains("show")) {
			btn.getStyleClass().remove("show");
			grid.setVisible(false);
			grid.managedProperty().bind(grid.visibleProperty());
			System.out.println(btn.getStyleClass());
			}
		else {
			btn.getStyleClass().add("show");
			grid.setVisible(true);
			System.out.println(btn.getStyleClass());

		}
	
	}
}
