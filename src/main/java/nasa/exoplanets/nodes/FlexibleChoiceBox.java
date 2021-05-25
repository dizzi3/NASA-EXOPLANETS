package nasa.exoplanets.nodes;

import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import nasa.exoplanets.query.Query;
import nasa.exoplanets.query.QueryUI;

public class FlexibleChoiceBox extends ChoiceBox<String>{
	
	public static ChoiceBox<String> model;
	private QueryUI queryUI;
	
	public FlexibleChoiceBox(QueryUI queryUI) {

		this.queryUI = queryUI;
		
		FlexibleNode.copyProperties(this, model);
		addQueries();
		addOnValueChangedListener();
		
	}
	
	private void addQueries() {
		
		for(Query q : Query.queries) {
			
			if(!QueryUI.usedQueries.contains(q))
				getItems().add(q.getName());
		}
		
		
		setValue(getItems().get(0));
		
		QueryUI.usedQueries.add(Query.find((String) getValue()));
		
	}
	
	private void addOnValueChangedListener() {
		
		setOnAction( event -> {
			
			updateItems(queryUI.getChoiceBoxes());
			
		});
		
	}
	
	public void removeAllItemsExceptTheCurrent() {
		
		for(int i = 0; i < getItems().size(); i++) {
			
			if(!getItems().get(i).equals(getValue())) {
				getItems().remove(i);
				i--;
			}
			
		}
		
	}
	
	public static void updateItems(ArrayList<FlexibleChoiceBox> cBoxes) {
		
		QueryUI.usedQueries.clear();
		
		for(FlexibleChoiceBox b : cBoxes)
			QueryUI.usedQueries.add(Query.find(b.getValue()));
		
		ArrayList<Query> nonUsedQueries = QueryUI.getNonUsedQueries();
		
		for(FlexibleChoiceBox b : cBoxes) {
			b.removeAllItemsExceptTheCurrent();
			
			for(Query q : nonUsedQueries)
				b.getItems().add(q.getName());
		}
	}

}
