package nasa.exoplanets.vars;

import java.util.ArrayList;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

public class Query {

	public enum DATA_TYPE{
		INT, STRING
	};
	
	private String name;
	private DATA_TYPE dataType;
	

	public static ArrayList<Query> queries = new ArrayList<Query>() {{
		
		add(new Query("Discovery facility", DATA_TYPE.STRING));
		add(new Query("Host name", DATA_TYPE.STRING));
		add(new Query("Discovery method", DATA_TYPE.STRING));
		add(new Query("Year of discovery", DATA_TYPE.INT));
		
	}};
	
	public static ArrayList<Query>usedQueries = new ArrayList<Query>();
	
	public static Query find(String query) {
		
		for(Query q : queries) {
			
			if(q.name.equals(query))
				return q;
			
		}
		
		return null;
	}
	
	public Query(String name, DATA_TYPE dataType) {
		this.name = name;
		this.dataType = dataType;
	}
	
	public String getName() {
		return name;
	}
	
	public DATA_TYPE getDataType() {
		return dataType;
	}
	
	public static void removeElementUsedByOtherCB(ArrayList<HBox> queryHBoxes){
		
		for(Query q : Query.usedQueries) {
			
			boolean shouldntRemove = false;
			for(HBox b : queryHBoxes) {
				
				ChoiceBox<String> currentCBox = (ChoiceBox<String>)b.getChildren().get(0);

				if(q.getName().equals(currentCBox.getValue()))
					shouldntRemove = true;
				
			}
			
			if(!shouldntRemove) {
				Query.usedQueries.remove(q);
				return;
			}
		}
		
	}
	
	public static ArrayList<Query> getNonUsedQueries(){
		
		ArrayList<Query> nonUsedQueries = new ArrayList<>();
		
		for(Query q : queries) {
			if(!usedQueries.contains(q))
				nonUsedQueries.add(q);
		}
		
		return nonUsedQueries;
	}

	
}
