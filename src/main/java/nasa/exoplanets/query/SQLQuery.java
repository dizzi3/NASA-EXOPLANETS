package nasa.exoplanets.query;

import java.util.ArrayList;

public class SQLQuery {

	public static String generate(ArrayList<String>properties, ArrayList<QueryUIElement> elements) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+");
		
		for(String column : properties)
			builder.append(column + ",");
		
		builder.deleteCharAt(builder.length()-1);
		
		builder.append("+from+pscomppars+where+");
		
		if(elements.size() == 1) {
			
			if(elements.get(0).getTextField().getText().equals("")) {
				
				builder.delete(builder.length() - 7, builder.length());
				builder.append("&format=json");
				
				return builder.toString();
			}
			
		}
		
		for(QueryUIElement e : elements) {
			
			Query q = Query.find(e.getChoiceBox().getValue().toString());
			
			String columnName = q.getColumnName();
			String value = e.getTextField().getText();
			value = value.replaceAll(" ", "%20");
			
			builder.append(columnName + "+like+%27" + value + "%27+and+");
		}
		
		builder.delete(builder.length()-5, builder.length());
		
		builder.append("&format=json");
		
		return builder.toString();
	}
	
}
