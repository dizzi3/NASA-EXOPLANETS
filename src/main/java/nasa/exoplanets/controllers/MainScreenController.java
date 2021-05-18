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
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleTable;
import nasa.exoplanets.query.Query;
import nasa.exoplanets.query.QueryUI;
import nasa.exoplanets.query.SQLQuery;

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
	private VBox queriesVBox;
	
	@FXML
	private VBox mainVBox;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox queryChoiceBox;
	
	private QueryUI queryUI;
	
	public void initialize(){

		mainQueryHBox.setManaged(false);
		
		queryUI = new QueryUI(queryChoiceBox, queryInputTextField, addQueryButton, queriesVBox);

		
		
		
		
		//JSONObject jsonObj = JSON.readFromURL("https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,pl_masse,ra,dec+from+ps+where+upper(soltype)+like+%27%CONF%%27+and+pl_masse+between+0.5+and+2.0&format=json").getJSONObject(0);
		/*
		ObservableList<Planet>data = FXCollections.observableArrayList(
				
				new Planet("11 Com b", "11 Com", 2, 1, "Radial Velocity"),
				new Planet("11 UMi b", "11 UMi", 1, 1, "Radial Velocity"),
				new Planet("14 And b", "14 And", 1, 1, "Radial Velocity")
				
		);*/
		
		//1200x675
		
		
		
	}
	
	public void onSearchButtonClick() {
		ObservableList<Planet>data = FXCollections.observableArrayList();
		
		ArrayList<String>properties = new ArrayList<String>() {{
			
			add("pl_name");
			add("hostname");
			add("sy_snum");
			add("sy_pnum");
			add("discoverymethod");
			
		}};
		
		try {
			String query = SQLQuery.generate(properties, queryUI.getElements());
			JSONArray jArray  = JSON.readFromURL(query);
			
			for(int i = 0; i < jArray.length(); i++) {
				
				JSONObject obj = jArray.getJSONObject(i);
				String name = obj.getString("pl_name");
				String hostname = obj.getString("hostname");
				String discoverymethod = obj.getString("discoverymethod");
				int numberOfStars = obj.getInt("sy_snum");
				int numberOfPlanets = obj.getInt("sy_pnum");
				
				data.add(new Planet(name, hostname, numberOfStars, numberOfPlanets, discoverymethod));
				
			}
			
			System.out.println(jArray.getJSONObject(0).toString());
		} catch (IOException e) {}
		
		
		
		FlexibleTable table = new FlexibleTable(data);
		table.setPrefHeight(750.0);
		mainVBox.getChildren().add(table);
		
	}
	
}
