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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleHBox;
import nasa.exoplanets.vars.Query;

public class MainScreenController {

	@FXML
	private ChoiceBox<String> mainQueryChoiceBox;
	
	@FXML
	private TextField mainQueryInputTextField;
	
	@FXML
	private Button addQueryButton;
	
	@FXML
	private Button removeQueryButton;
	
	@FXML
	private HBox mainQueryHBox;
	
	@FXML
	private VBox mainVBox;
	
	private ArrayList<HBox> queryHBoxes = new ArrayList<>();
	private int maxAmountOfChoiceBoxes;
	
	
	public void initialize(){

		initializeQueryChoiceBox(mainQueryChoiceBox);

		maxAmountOfChoiceBoxes = Query.queries.size();
		queryHBoxes.add(mainQueryHBox);
	}
	
	private void initializeQueryChoiceBox(ChoiceBox<String> cBox) {
		
		for(Query q : Query.queries) {
			
			if(!Query.usedQueries.contains(q))
				cBox.getItems().add(q.getName());
		}
		
		cBox.setValue(cBox.getItems().get(0));
		Query.usedQueries.add(Query.find(cBox.getValue()));
		
		addOnChangeValueListener(cBox);
		
		updateChoiceBoxes();
	}
	
	private void addOnChangeValueListener(ChoiceBox<String> cBox) {
		
		cBox.setOnAction(event -> {
			
			Query.usedQueries.add(Query.find(cBox.getValue()));
			Query.removeElementUsedByOtherCB(queryHBoxes);
			
			
		});
		
	}
	
	private void updateChoiceBoxes() {

		ArrayList<ChoiceBox> cBoxes = new ArrayList<>();
		
		for(HBox b : queryHBoxes)
			cBoxes.add((ChoiceBox)b.getChildren().get(0));
		
		FlexibleChoiceBox.updateItems(cBoxes);
		
	}
	
	public void onAddQueryButtonClick() {
		
		if(queryHBoxes.size() >= maxAmountOfChoiceBoxes)
			return;
		
		makeNewQueryHBox();
	}
	
	private void makeNewQueryHBox() {
		
		FlexibleHBox hBox = new FlexibleHBox(mainQueryHBox);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.setPrefWidth(mainQueryChoiceBox.getPrefWidth());
		
		TextField textField = new TextField();
		
		initializeQueryChoiceBox(choiceBox);

		copyStyleClasses(mainQueryChoiceBox, choiceBox);
		copyStyleClasses(mainQueryInputTextField, textField);
		
		hBox.getChildren().add(choiceBox);
		hBox.getChildren().add(textField);
		
		queryHBoxes.add(hBox);
		
		mainVBox.getChildren().add(hBox);
	}
	
	private void copyStyleClasses(Node n1, Node n2) {
		
		for(String s : n1.getStyleClass())
			n2.getStyleClass().add(s);
		
	}
	
}
