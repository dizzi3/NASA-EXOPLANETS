package nasa.exoplanets.controllers;

import java.util.ArrayList;

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
import javafx.scene.layout.VBox;
import nasa.exoplanets.data.structures.Planet;
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleTable;
import nasa.exoplanets.query.Query;
import nasa.exoplanets.query.QueryUI;

public class MainScreenController {
	
	@FXML
	private TextField queryInputTextField;
	
	@FXML
	private Button addQueryButton;
	
	@FXML
	private Button removeQueryButton;
	
	@FXML
	private HBox mainQueryHBox;
	
	@FXML
	private VBox mainVBox;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox queryChoiceBox;
	
	private QueryUI queryUI;
	
	public void initialize(){

		mainQueryHBox.setManaged(false);
		
		queryUI = new QueryUI(queryChoiceBox, queryInputTextField, addQueryButton, mainVBox);

		
		ObservableList<Planet>data = FXCollections.observableArrayList(
		
				new Planet("11 Com b", "11 Com", 2, 1, "Radial Velocity"),
				new Planet("11 UMi b", "11 UMi", 1, 1, "Radial Velocity"),
				new Planet("14 And b", "14 And", 1, 1, "Radial Velocity")
				
		);
		
		FlexibleTable table = new FlexibleTable(data);
		mainVBox.getChildren().add(table);
		
	}
	
}
