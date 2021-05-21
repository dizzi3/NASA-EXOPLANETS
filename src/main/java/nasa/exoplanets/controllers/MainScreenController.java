package nasa.exoplanets.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import nasa.exoplanets.helpers.MainScreenUIHelper;
import nasa.exoplanets.query.QueryUI;

public class MainScreenController {
	
	private QueryUI queryUI;
	private MainScreenUIHelper UIHelper;
	
	public void initialize(){
		
		mainQueryHBox.setManaged(false);
		
		queryUI = new QueryUI(queryChoiceBox, queryInputTextField, addQueryButton, queriesVBox);

		UIHelper = new MainScreenUIHelper(displayDataAmountChoiceBox, searchButton, tableStackPane, queryUI);
		
	}
	
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
	
	@FXML
	private ChoiceBox<String> queryChoiceBox;
	
	@FXML
	private ChoiceBox<String> displayDataAmountChoiceBox;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private StackPane tableStackPane;
	
}
