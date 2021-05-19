package nasa.exoplanets.helpers;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import nasa.exoplanets.data.structures.Planet;
import nasa.exoplanets.nodes.FlexibleTable;
import nasa.exoplanets.query.QueryUI;
import nasa.exoplanets.query.SQLQuery;

public class MainScreenUIHelper {

	private ChoiceBox<String> displayDataAmountChoiceBox;
	private Button searchButton;
	private VBox tableVBox;
	private QueryUI queryUI;
	
	public enum DATA_AMOUNT{
		
		BASIC,
		INTERMEDIATE,
		ADVANCED
		
	}
	
	private DATA_AMOUNT dataAmount = DATA_AMOUNT.BASIC;
	
	public MainScreenUIHelper(ChoiceBox<String> displayDataAmountChoiceBox,
							  Button searchButton,
							  VBox tableVBox,
							  QueryUI queryUI) {
		this.displayDataAmountChoiceBox = displayDataAmountChoiceBox;
		this.searchButton = searchButton;
		this.tableVBox = tableVBox;
		this.queryUI = queryUI;
		
		addOnSearchButtonClickListener();
		initializeDisplayInfoCB();
	}
	
	private void addOnSearchButtonClickListener() {
		
		searchButton.setOnAction(event -> {
			
			ArrayList<String>properties = getProperties();
			ObservableList<Planet>planets = FXCollections.observableArrayList();
			
			try {
				
				String query = SQLQuery.generate(properties, queryUI.getElements());
				planets = JSON.getPlanetsFromURL(query, dataAmount);
				
			} catch (IOException e) {}
			
			
			FlexibleTable table = new FlexibleTable(planets);
			table.setPrefHeight(750.0);
			tableVBox.getChildren().add(table);
			
		});
		
	}
	
	private void initializeDisplayInfoCB() {
		
		displayDataAmountChoiceBox.getItems().add("Basic");
		displayDataAmountChoiceBox.getItems().add("Intermediate");
		displayDataAmountChoiceBox.getItems().add("Advanced");
		displayDataAmountChoiceBox.setValue("Basic");
		
	}
	
	private DATA_AMOUNT getDataAmountFromCB() {
		
		if(displayDataAmountChoiceBox.getValue().equals(displayDataAmountChoiceBox.getItems().get(0)))
			return DATA_AMOUNT.BASIC;
		else if(displayDataAmountChoiceBox.getValue().equals(displayDataAmountChoiceBox.getItems().get(1)))
			return DATA_AMOUNT.INTERMEDIATE;
		else return DATA_AMOUNT.ADVANCED;
		
	}
	
	private ArrayList<String> getProperties(){
		
		ArrayList<String> properties = new ArrayList<String>();
		
		DATA_AMOUNT dataAmount = getDataAmountFromCB();
		
		properties.add("pl_name");
		properties.add("hostname");
		properties.add("sy_snum");
		properties.add("sy_pnum");
		properties.add("discoverymethod");
		
		if(dataAmount.equals(DATA_AMOUNT.INTERMEDIATE) || dataAmount.equals(DATA_AMOUNT.ADVANCED)) {
			
			//TODO: FINISH
			
		}
		
		if(dataAmount.equals(DATA_AMOUNT.ADVANCED)) {
			
			//TODO: FINISH
			
		}
			
		return properties;
		
	}
	
}
