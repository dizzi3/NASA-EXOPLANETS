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
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;
import nasa.exoplanets.planets.BasicPlanet;

public class JSON {

	public static JSONArray readFromURL(String URL) throws MalformedURLException, IOException {
		
		InputStream is = new URL(URL).openStream();
		
		String rawData = IOUtils.toString(is, Charset.forName("UTF-8"));
		
		is.close();
		
		return new JSONArray(rawData);
	}
	
	public static ObservableList<BasicPlanet> getPlanetsFromURL(String URL, DATA_AMOUNT dataAmount) throws MalformedURLException, IOException {
		
		ObservableList<BasicPlanet>planets = FXCollections.observableArrayList();
		
		JSONArray jArray = readFromURL(URL);
		
		for(int i = 0; i < jArray.length(); i++) {
			
			JSONObject obj = jArray.getJSONObject(i);
			BasicPlanet basicPlanet = getBasicPlanet(obj);
			
			if(dataAmount.equals(DATA_AMOUNT.BASIC)) {
				planets.add(basicPlanet);
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
	
	private static BasicPlanet getBasicPlanet(JSONObject obj) {
		
		String name = obj.getString("pl_name");
		String hostname = obj.getString("hostname");
		String discoverymethod = obj.getString("discoverymethod");
		int numberOfStars = obj.getInt("sy_snum");
		int numberOfPlanets = obj.getInt("sy_pnum");
		int discoveryYear = obj.getInt("disc_year");
		String discoveryFacility = obj.getString("disc_facility");
		
		return new BasicPlanet(name, hostname, numberOfStars, numberOfPlanets, discoverymethod, discoveryYear, discoveryFacility);
	}
	
}
