package nasa.exoplanets.controllers;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import nasa.exoplanets.data.structures.Planet;
import nasa.exoplanets.helpers.JSON;
import nasa.exoplanets.helpers.MainScreenUIHelper;
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleTable;
import nasa.exoplanets.query.Query;
import nasa.exoplanets.query.QueryUI;
import nasa.exoplanets.query.SQLQuery;

public class MainScreenController {
	
	@FXML
	private StackPane MainStackPane;
	
	@FXML
	private TextField queryInputTextField;
	
	@FXML
	private Button addQueryButton;
	
	@FXML
	private Button removeQueryButton;
	
	@FXML
	private HBox mainQueryHBox;
	
	@FXML
	private VBox queriesVBox;
	
	@FXML
	private VBox mainVBox;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox queryChoiceBox;
	
	@FXML
	private ChoiceBox<String> displayDataAmountChoiceBox;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private StackPane tableStackPane;
	
	private QueryUI queryUI;
	private MainScreenUIHelper UIHelper;
	

	//TODO: 1200x675 
	public static double WIDTH, HEIGHT;
	
	public void initialize(){

		WIDTH = MainStackPane.getPrefWidth();
		HEIGHT = MainStackPane.getPrefHeight();
		
		mainQueryHBox.setManaged(false);
		
		queryUI = new QueryUI(queryChoiceBox, queryInputTextField, addQueryButton, queriesVBox);

		UIHelper = new MainScreenUIHelper(displayDataAmountChoiceBox, searchButton, tableStackPane, queryUI);
		
		
		
	}
	
}
