package nasa.exoplanets.query;

import java.util.ArrayList;

import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;

public class Query {

	public enum DATA_TYPE{
		NUMBER, TEXT
	};
	
	private String name;
	private String columnName;
	private DATA_TYPE dataType;

	public static ArrayList<Query> queries = new ArrayList<Query>() {{
		
		add(new Query("Discovery facility", "disc_facility", DATA_TYPE.TEXT));
		add(new Query("Host name", "hostname", DATA_TYPE.TEXT));
		add(new Query("Discovery method", "discoverymethod", DATA_TYPE.TEXT));
		add(new Query("Year of discovery", "disc_year", DATA_TYPE.NUMBER));
		add(new Query("Number of planets", "sy_pnum", DATA_TYPE.NUMBER));
		
	}};
	
	
	public Query(String name, String columnName, DATA_TYPE dataType) {
		this.name = name;
		this.columnName = columnName;
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

	public String getColumnName() {
		return this.columnName;
	}
	
}
