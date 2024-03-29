package nasa.exoplanets.helpers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import nasa.exoplanets.Main;
import nasa.exoplanets.nodes.tables.AdvancedTable;
import nasa.exoplanets.nodes.tables.BasicTable;
import nasa.exoplanets.nodes.tables.IntermediateTable;
import nasa.exoplanets.planets.AdvancedPlanet;
import nasa.exoplanets.planets.BasicPlanet;
import nasa.exoplanets.planets.IntermediatePlanet;
import nasa.exoplanets.query.QueryUI;
import nasa.exoplanets.query.SQLQuery;

public class MainScreenUIHelper {

	private ChoiceBox<String> displayDataAmountChoiceBox;
	private Button searchButton;
	private QueryUI queryUI;
	
	public enum DATA_AMOUNT{
		
		BASIC,
		INTERMEDIATE,
		ADVANCED
		
	}
	
	public MainScreenUIHelper(ChoiceBox<String> displayDataAmountChoiceBox,
							  Button searchButton,
							  QueryUI queryUI) {
		this.displayDataAmountChoiceBox = displayDataAmountChoiceBox;
		this.searchButton = searchButton;
		this.queryUI = queryUI;
		
		initializeDisplayInfoCB();
		addOnSearchButtonClickListener();
	}
	
	private void initializeDisplayInfoCB() {
		
		for(DATA_AMOUNT d : DATA_AMOUNT.values()) {
			
			String dataAmountString = StringManipulator.firstUpperRestLowercase(d.name());
			displayDataAmountChoiceBox.getItems().add(dataAmountString);
			
		}

		displayDataAmountChoiceBox.setValue(displayDataAmountChoiceBox.getItems().get(0));
		
	}
	
	private void addOnSearchButtonClickListener() {
		
		searchButton.setOnAction(event -> {
			
			ArrayList<String>properties = getProperties();
			ObservableList<BasicPlanet>planets = FXCollections.observableArrayList();

			try {
				
				String query = SQLQuery.generate(properties, queryUI.getElements());
				planets = JSON.getPlanetsFromURL(query, getDataAmountFromCB());
				
			} catch (IOException e) {}
			
			try {
				Main.switchToResultScene(getDataFilledTable(planets));
			} catch (IOException e) {}
			
		});
		
	}
	
	private ArrayList<String> getProperties(){
		
		DATA_AMOUNT dataAmount = getDataAmountFromCB();
		
		if(dataAmount.equals(DATA_AMOUNT.BASIC))
			return BasicPlanet.getProperties();
		
		if(dataAmount.equals(DATA_AMOUNT.INTERMEDIATE))
			return IntermediatePlanet.getProperties();
		
		if(dataAmount.equals(DATA_AMOUNT.ADVANCED))
			return AdvancedPlanet.getProperties();
			
		return BasicPlanet.getProperties();
	}
	
	private DATA_AMOUNT getDataAmountFromCB() {
		
		String choiceBoxValue = displayDataAmountChoiceBox.getValue();
		
		for(DATA_AMOUNT d : DATA_AMOUNT.values()) {
			
			String dataAmountString = StringManipulator.firstUpperRestLowercase(d.name());
			if(choiceBoxValue.equals(dataAmountString))
				return d;
			
		}

		return DATA_AMOUNT.BASIC;
	}
	
	private BasicTable getDataFilledTable(ObservableList<BasicPlanet>planets) {
		
		BasicTable table;
		DATA_AMOUNT dataAmount = getDataAmountFromCB();
		
		if(dataAmount == DATA_AMOUNT.BASIC)
			table = new BasicTable(planets);
		else if(dataAmount == DATA_AMOUNT.INTERMEDIATE)
			table = new IntermediateTable(planets);
		else 
			table = new AdvancedTable(planets);
		
		return table;
	}
	
}
