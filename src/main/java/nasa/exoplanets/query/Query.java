package nasa.exoplanets.query;

import java.util.ArrayList;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

public class Query {

	public enum DATA_TYPE{
		NUMBER, TEXT
	};
	
	private String name;
	private DATA_TYPE dataType;
	

	public static ArrayList<Query> queries = new ArrayList<Query>() {{
		
		add(new Query("Discovery facility", DATA_TYPE.TEXT));
		add(new Query("Host name", DATA_TYPE.TEXT));
		add(new Query("Discovery method", DATA_TYPE.TEXT));
		add(new Query("Year of discovery", DATA_TYPE.NUMBER));
		add(new Query("Number of planets", DATA_TYPE.NUMBER));
		
	}};
	
	
	public Query(String name, DATA_TYPE dataType) {
		this.name = name;
		this.dataType = dataType;
	}
	
	public static Query find(String query) {
		
		for(Query q : queries) {
			
			if(q.name.equals(query))
				return q;
			
		}
		
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	public DATA_TYPE getDataType() {
		return dataType;
	}

	
}
