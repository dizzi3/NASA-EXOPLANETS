package nasa.exoplanets.controllers;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import nasa.exoplanets.nodes.FlexibleChoiceBox;
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
	
	@SuppressWarnings("unchecked")
	private QueryUI queryUI;
	
	public void initialize(){

		mainQueryHBox.setManaged(false);
		
		queryUI = new QueryUI(queryChoiceBox, queryInputTextField, addQueryButton, mainVBox);

	}
	
}
