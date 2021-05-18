package nasa.exoplanets.query;

import java.util.ArrayList;

public class SQLQuery {

	//"https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,pl_masse,ra,dec+from+ps+where+upper(soltype)+like+%27%CONF%%27+and+pl_masse+between+0.5+and+2.0&format=json"
	
	public static String generate(ArrayList<String>properties, ArrayList<QueryUIElement> elements) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+");
		
		for(String column : properties)
			builder.append(column + ",");
		
		builder.deleteCharAt(builder.length()-1);
		
		builder.append("+from+pscomppars+where+");
		
		for(QueryUIElement e : elements) {
			
			Query q = Query.find(e.getChoiceBox().getValue());
			String columnName = q.getColumnName();
			String value = e.getTextField().getText();
			
			builder.append(columnName + "+like+%27" + value + "%27+and+");
		}
		
		builder.delete(builder.length()-5, builder.length());
		
		builder.append("&format=json");
		
		System.out.println(builder.toString());
		
		return builder.toString();
	}
	
}
