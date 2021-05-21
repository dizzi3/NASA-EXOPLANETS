package nasa.exoplanets.planets;

import java.util.ArrayList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;

public class BasicPlanet {

	private SimpleStringProperty name;
	private SimpleStringProperty hostName;
	private SimpleIntegerProperty numberOfStars;
	private SimpleIntegerProperty numberOfPlanets;
	private SimpleStringProperty discoveryMethod;
	private SimpleIntegerProperty discoveryYear;
	private SimpleStringProperty discoveryFacility;
	
	public BasicPlanet(String name, String hostName, int numberOfStars,
			int numberOfPlanets, String discoveryMethod, int discoveryYear, String discoveryFacility) {
		
		this.name = new SimpleStringProperty(name);
		this.hostName = new SimpleStringProperty(hostName);
		this.numberOfStars = new SimpleIntegerProperty(numberOfStars);
		this.numberOfPlanets = new SimpleIntegerProperty(numberOfPlanets);
		this.discoveryMethod = new SimpleStringProperty(discoveryMethod);
		this.discoveryYear = new SimpleIntegerProperty(discoveryYear);
		this.discoveryFacility = new SimpleStringProperty(discoveryFacility);
	}
	
	public BasicPlanet(BasicPlanet other) {
		this.name = other.name;
		this.hostName = other.hostName;
		this.numberOfStars = other.numberOfStars;
		this.numberOfPlanets = other.numberOfPlanets;
		this.discoveryMethod = other.discoveryMethod;
		this.discoveryYear = other.discoveryYear;
		this.discoveryFacility = other.discoveryFacility;
	}
	
	public static ArrayList<String> getProperties(){
		
		ArrayList<String> properties = new ArrayList<String>();
		
		properties.add("pl_name");
		properties.add("hostname");
		properties.add("sy_snum");
		properties.add("sy_pnum");
		properties.add("discoverymethod");
		properties.add("disc_year");
		properties.add("disc_facility");
		
		return properties;
	}

	public String getName() {
		return name.get();
	}

	public String getHostName() {
		return hostName.get();
	}

	public int getNumberOfStars() {
		return numberOfStars.get();
	}

	public int getNumberOfPlanets() {
		return numberOfPlanets.get();
	}

	public String getDiscoveryMethod() {
		return discoveryMethod.get();
	}
	
	public int getDiscoveryYear() {
		return discoveryYear.get();
	}
	
	public String getDiscoveryFacility() {
		return this.discoveryFacility.get();
	}
	
}
