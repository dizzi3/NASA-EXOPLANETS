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
import nasa.exoplanets.planets.AdvancedPlanet;
import nasa.exoplanets.planets.BasicPlanet;
import nasa.exoplanets.planets.IntermediatePlanet;

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
			
			IntermediatePlanet intermediatePlanet = getIntermediatePlanet(obj, basicPlanet);
				
			if(dataAmount.equals(DATA_AMOUNT.INTERMEDIATE)) {
				planets.add(intermediatePlanet);
				continue;
			}
			
			AdvancedPlanet advancedPlanet = getAdvancedPlanet(obj, intermediatePlanet);
			planets.add(advancedPlanet);
			
		}
		
		return planets;
	}
	
	private static BasicPlanet getBasicPlanet(JSONObject obj) {
		
		String name = getStringProperty("pl_name", obj);
		String hostname = getStringProperty("hostname", obj);
		String discoverymethod = getStringProperty("discoverymethod", obj);
		String discoveryFacility = getStringProperty("disc_facility", obj);
		
		int numberOfStars = getIntProperty("sy_snum", obj);
		int numberOfPlanets = getIntProperty("sy_pnum", obj);
		int discoveryYear = getIntProperty("disc_year", obj);
		
		return new BasicPlanet(name, hostname, numberOfStars, numberOfPlanets, discoverymethod, discoveryYear, discoveryFacility);
	}
	
	private static IntermediatePlanet getIntermediatePlanet(JSONObject obj, BasicPlanet basicPlanet) {
		
		double orbitalPeriod = getDoubleProperty("pl_orbper", obj);
		double planetRadiusComparedToEarth = getDoubleProperty("pl_rade", obj);
		double planetMassComparedToEarth = getDoubleProperty("pl_bmasse", obj);
		double stellarSurfaceGravity = getDoubleProperty("st_logg", obj);
		double distance = getDoubleProperty("sy_dist", obj);
		
		return new IntermediatePlanet(basicPlanet, orbitalPeriod, planetRadiusComparedToEarth, planetMassComparedToEarth,
				stellarSurfaceGravity, distance);
	}
	
	private static AdvancedPlanet getAdvancedPlanet(JSONObject obj, IntermediatePlanet intermediatePlanet) {
		
		int controversialFlag = getIntProperty("pl_controv_flag", obj);
		double orbitSemiMajorAxis = getDoubleProperty("pl_orbsmax", obj);
		double planetRadiusComparedToJupiter = getDoubleProperty("pl_radj", obj);
		double planetMassComparedToJupiter = getDoubleProperty("pl_bmassj", obj);
		String planetMassProvenance = getStringProperty("pl_bmassprov", obj);
		double eccentricity = getDoubleProperty("pl_orbeccen", obj);
		double insolationFlux = getDoubleProperty("pl_insol", obj);
		double equilibriumTemperature = getDoubleProperty("pl_eqt", obj);
		int dataShowTransitTimingVariations = getIntProperty("ttv_flag", obj);
		String spectralType = getStringProperty("st_spectype", obj);
		double stellarEffectiveTemperature = getDoubleProperty("st_teff", obj);
		double stellarRadius = getDoubleProperty("st_rad", obj);
		double stellarMass = getDoubleProperty("st_mass", obj);
		double stellarMetallicity = getDoubleProperty("st_met", obj);
		String stellarMetallicityRatio = getStringProperty("st_metratio", obj);
		String RA = getStringProperty("rastr", obj);
		String Dec = getStringProperty("decstr", obj);
		double VJohnsonMagnitude = getDoubleProperty("sy_vmag", obj);
		double Ks2MASSMagnitude = getDoubleProperty("sy_kmag", obj);
		double GaiaMagnitude = getDoubleProperty("sy_gaiamag", obj);
	
		return new AdvancedPlanet(intermediatePlanet, controversialFlag, orbitSemiMajorAxis, planetRadiusComparedToJupiter,
				planetMassComparedToJupiter, planetMassProvenance, eccentricity, insolationFlux, equilibriumTemperature, 
				dataShowTransitTimingVariations, spectralType, stellarEffectiveTemperature, stellarRadius, stellarMass,
				stellarMetallicity, stellarMetallicityRatio, RA, Dec, VJohnsonMagnitude, Ks2MASSMagnitude, GaiaMagnitude);
	}
	
	private static double getDoubleProperty(String key, JSONObject obj) {
		
		try {
			return obj.getDouble(key);
		}catch(Exception e) {}
		
		return 0.0;
	}
	
	private static int getIntProperty(String key, JSONObject obj) {
		
		try {
			return obj.getInt(key);
		}catch(Exception e) {}
		
		return 0;
	}
	
	private static String getStringProperty(String key, JSONObject obj) {
		
		try {
			return obj.getString(key);
		}catch(Exception e) {}
		
		return "";
	}
	
}
