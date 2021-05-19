package nasa.exoplanets.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nasa.exoplanets.data.structures.Planet;
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;

public class JSON {

	public static JSONArray readFromURL(String URL) throws MalformedURLException, IOException {
		
		InputStream is = new URL(URL).openStream();
		
		String rawData = IOUtils.toString(is, Charset.forName("UTF-8"));
		
		is.close();

		return new JSONArray(rawData);
	}
	
	public static ObservableList<Planet> getPlanetsFromURL(String URL, DATA_AMOUNT dataAmount) throws MalformedURLException, IOException {
		
		ObservableList<Planet>planets = FXCollections.observableArrayList();
		
		JSONArray jArray = readFromURL(URL);
		
		for(int i = 0; i < jArray.length(); i++) {
			
			JSONObject obj = jArray.getJSONObject(i);
			String name = obj.getString("pl_name");
			String hostname = obj.getString("hostname");
			String discoverymethod = obj.getString("discoverymethod");
			int numberOfStars = obj.getInt("sy_snum");
			int numberOfPlanets = obj.getInt("sy_pnum");
			
			if(dataAmount.equals(DATA_AMOUNT.BASIC)) {
				planets.add(new Planet(dataAmount, name, hostname, numberOfStars, numberOfPlanets, discoverymethod));
				continue;
			}
			
			
			//TODO: add intermediate data	
				
				
			if(dataAmount.equals(DATA_AMOUNT.INTERMEDIATE)) {
				//TODO : add planet with intermediata data amount
				continue;
			}
			
			//TODO: add advanced data and add planet
			
		}
		
		return planets;
	}
	
}
