package nasa.exoplanets.data.structures;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;

public class Planet {

	private SimpleStringProperty name;
	private SimpleStringProperty hostName;
	private SimpleIntegerProperty numberOfStars;
	private SimpleIntegerProperty numberOfPlanets;
	private SimpleStringProperty discoveryMethod;
	
	private DATA_AMOUNT dataAmount;
	
	public Planet(DATA_AMOUNT dataAmount, String name, String hostName, int numberOfStars, int numberOfPlanets, String discoveryMethod) {
		
		this.dataAmount = dataAmount;
		this.name = new SimpleStringProperty(name);
		this.hostName = new SimpleStringProperty(hostName);
		this.numberOfStars = new SimpleIntegerProperty(numberOfStars);
		this.numberOfPlanets = new SimpleIntegerProperty(numberOfPlanets);
		this.discoveryMethod = new SimpleStringProperty(discoveryMethod);
		
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
	
	public DATA_AMOUNT getDataAmount() {
		return this.dataAmount;
	}
	
}
