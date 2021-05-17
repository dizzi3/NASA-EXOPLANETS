package nasa.exoplanets.query;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import nasa.exoplanets.nodes.FlexibleAddQueryButton;
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleRemoveQueryButton;
import nasa.exoplanets.nodes.FlexibleTextField;

public class QueryUIElement extends HBox{

	private static final Pos ALIGNMENT = Pos.CENTER;
	private static final double SPACING = 10.0;
	private static final double WIDTH = 1200.0;
	private static final double HEIGHT = 0.0;
	private static final double PADDING = 5.0;
	
	private FlexibleTextField textField = new FlexibleTextField();
	private FlexibleRemoveQueryButton removeQueryButton;
	private FlexibleAddQueryButton addQueryButton;
	private FlexibleChoiceBox choiceBox;
	
	public QueryUIElement(QueryUI queryUI) { 
		initializeHBoxProperties(); 
		initializeNodes(queryUI);
		addNodes();
	}
	
	private void initializeHBoxProperties() {
		setAlignment(ALIGNMENT);
		setSpacing(SPACING);
		setPrefWidth(WIDTH);
		setPrefHeight(HEIGHT);
		this.setPadding(new Insets(PADDING, 0.0, PADDING, 0.0));
	}
	
	private void initializeNodes(QueryUI queryUI) {
		
		addQueryButton = new FlexibleAddQueryButton(queryUI);
		choiceBox = new FlexibleChoiceBox(queryUI);
		removeQueryButton = new FlexibleRemoveQueryButton(queryUI, this);
		
	}
	
	private void addNodes() {
		getChildren().add(choiceBox);
		getChildren().add(textField);
		getChildren().add(removeQueryButton);
		getChildren().add(addQueryButton);
	}
	
	public void hideAddQueryButton() {
		addQueryButton.setVisible(false);
	}
	
	public void showAddQueryButton() {
		addQueryButton.setVisible(true);
	}
	
	public FlexibleChoiceBox getChoiceBox() {
		return this.choiceBox;
	}
	
}
