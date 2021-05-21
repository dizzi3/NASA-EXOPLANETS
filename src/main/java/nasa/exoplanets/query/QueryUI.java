package nasa.exoplanets.query;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nasa.exoplanets.nodes.FlexibleButton;
import nasa.exoplanets.nodes.FlexibleChoiceBox;
import nasa.exoplanets.nodes.FlexibleTextField;

public class QueryUI {
	
	public static ArrayList<Query>usedQueries = new ArrayList<Query>();
	private ArrayList<QueryUIElement> elements = new ArrayList<QueryUIElement>();
	private VBox mainVBox;
	
	public QueryUI(ChoiceBox<String> choiceBoxModel,
			   	   TextField textFieldModel,
				   Button buttonModel,
				   VBox mainVBox) {
		
		FlexibleChoiceBox.model = choiceBoxModel;
		FlexibleTextField.model = textFieldModel;
		FlexibleButton.model = buttonModel;
		
		this.mainVBox = mainVBox;
		
		addElement();
	}
	
	public void addElement() {
		
		QueryUIElement element = new QueryUIElement(this); 
		elements.add(element);
		mainVBox.getChildren().add(element);
		FlexibleChoiceBox.updateItems(getChoiceBoxes());
		updateAddButtons();
		
	}
	
	public ArrayList<FlexibleChoiceBox> getChoiceBoxes(){
		
		ArrayList<FlexibleChoiceBox> cBoxes = new ArrayList<>();
		for(QueryUIElement e : elements)
			cBoxes.add(e.getChoiceBox());
		
		return cBoxes;
	}
	
	private void updateAddButtons() {
		
		QueryUIElement lastElement = elements.get(elements.size()-1);
		
		for(QueryUIElement e : elements) {
			
			if(e.equals(lastElement))
				e.showAddQueryButton();
			else
				e.hideAddQueryButton();
			
		}
		
	}
	
	public void removeElement(QueryUIElement element) {
		
		elements.remove(element);
		mainVBox.getChildren().remove(element);
		FlexibleChoiceBox.updateItems(getChoiceBoxes());
		updateAddButtons();
		
	}
	
	public static ArrayList<Query> getNonUsedQueries(){
		
		ArrayList<Query> nonUsedQueries = new ArrayList<>();
		
		for(Query q : Query.queries) {
			if(!usedQueries.contains(q))
				nonUsedQueries.add(q);
		}
		
		return nonUsedQueries;
	}
	
	public int getAmountOfElements() {
		return this.elements.size();
	}
	
	public ArrayList<QueryUIElement> getElements(){
		return this.elements;
	}
	
}
