package nasa.exoplanets.query;

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