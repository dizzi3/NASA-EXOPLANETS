package nasa.exoplanets.planets;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;

public class IntermediatePlanet extends BasicPlanet{

	private BasicPlanet basicPlanet;
	
	private SimpleDoubleProperty orbitalPeriod;
	private SimpleDoubleProperty planetRadiusComparedToEarth;
	
	public IntermediatePlanet(BasicPlanet basicPlanet, double orbitalPeriod,
			double planetRadiusComparedToEarth){
		
		super(basicPlanet);
		this.basicPlanet = basicPlanet;
		this.orbitalPeriod = new SimpleDoubleProperty(orbitalPeriod);
		this.planetRadiusComparedToEarth = new SimpleDoubleProperty(planetRadiusComparedToEarth);
		
	}
	
	public IntermediatePlanet(IntermediatePlanet other) {
		super(other.basicPlanet);
		
		this.orbitalPeriod = other.orbitalPeriod;
		this.planetRadiusComparedToEarth = other.planetRadiusComparedToEarth;
	}

	public static ArrayList<String> getProperties(){
		
		ArrayList<String> properties = BasicPlanet.getProperties();
		
		properties.add("pl_orbper");
		properties.add("pl_rade");
		
		return properties;
	}
	
	public double getOrbitalPeriod() {
		return orbitalPeriod.get();
	}
	
	public double getPlanetRadiusComparedToEarth() {
		return planetRadiusComparedToEarth.get();
	}
	
}
