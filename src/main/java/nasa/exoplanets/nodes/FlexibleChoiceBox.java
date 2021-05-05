package nasa.exoplanets.nodes;

import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;
import nasa.exoplanets.vars.Query;

public class FlexibleChoiceBox extends ChoiceBox<String>{
	
	public void removeAllValuesExceptTheCurrent() {
		
		for(String s : getItems()) {
			
			if(!s.equals(getValue()))
				getItems().remove(s);
			
		}
	}
	
	public static void updateItems(ArrayList<ChoiceBox> cBoxes) {
		
		ArrayList<Query> nonUsedQueries = Query.getNonUsedQueries();
		
		for(ChoiceBox b : cBoxes) {
			b.removeAllValuesExceptTheCurrent();
			
			for(Query q : nonUsedQueries)
				b.getItems().add(q.getName());
		}
	}
	

}
