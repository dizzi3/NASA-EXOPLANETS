package nasa.exoplanets.data.structures;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;

public class Planet {

	//BASIC PROPERTIES
	private SimpleStringProperty name;
	private SimpleStringProperty hostName;
	private SimpleIntegerProperty numberOfStars;
	private SimpleIntegerProperty numberOfPlanets;
	private SimpleStringProperty discoveryMethod;
	private SimpleIntegerProperty discoveryYear;
	private SimpleStringProperty discoveryFacility;
	
	//INTERMEDIATE PROPERTIES
	
	
	
	private DATA_AMOUNT dataAmount;
	
	public Planet(DATA_AMOUNT dataAmount, String name, String hostName, int numberOfStars,
			int numberOfPlanets, String discoveryMethod, int discoveryYear, String discoveryFacility) {
		
		this.dataAmount = dataAmount;
		this.name = new SimpleStringProperty(name);
		this.hostName = new SimpleStringProperty(hostName);
		this.numberOfStars = new SimpleIntegerProperty(numberOfStars);
		this.numberOfPlanets = new SimpleIntegerProperty(numberOfPlanets);
		this.discoveryMethod = new SimpleStringProperty(discoveryMethod);
		this.discoveryYear = new SimpleIntegerProperty(discoveryYear);
		this.discoveryFacility = new SimpleStringProperty(discoveryFacility);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public String getHostName() {
		return hostName.get();
	}

	public void setHostName(String hostName) {
		this.hostName.set(hostName);;
	}

	public int getNumberOfStars() {
		return numberOfStars.get();
	}

	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars.set(numberOfStars);;
	}

	public int getNumberOfPlanets() {
		return numberOfPlanets.get();
	}

	public void setNumberOfPlanets(int numberOfPlanets) {
		this.numberOfPlanets.set(numberOfPlanets);;
	}

	public String getDiscoveryMethod() {
		return discoveryMethod.get();
	}

	public void setDiscoveryMethod(String discoveryMethod) {
		this.discoveryMethod.set(discoveryMethod);;
	}
	
	public int getDiscoveryYear() {
		return discoveryYear.get();
	}
	
	public void setDiscoveryYear(int discoveryYear) {
		this.discoveryYear.set(discoveryYear);
	}
	
	public String getDiscoveryFacility() {
		return this.discoveryFacility.get();
	}
	
	public void setDiscoveryFacility(String discoveryFacility) {
		this.discoveryFacility.set(discoveryFacility);
	}
	
	public DATA_AMOUNT getDataAmount() {
		return this.dataAmount;
	}
	
}
