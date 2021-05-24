package nasa.exoplanets.planets;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;

public class IntermediatePlanet extends BasicPlanet{

	private BasicPlanet basicPlanet;
	
	private SimpleDoubleProperty orbitalPeriod;
	private SimpleDoubleProperty planetRadiusComparedToEarth;
	private SimpleDoubleProperty planetMassComparedToEarth;
	private SimpleDoubleProperty stellarSurfaceGravity;
	private SimpleDoubleProperty distance;
	
	public IntermediatePlanet(BasicPlanet basicPlanet, double orbitalPeriod,
			double planetRadiusComparedToEarth, double planetMassComparedToEarth,
			double stellarSurfaceGravity, double distance){
		
		super(basicPlanet);
		this.basicPlanet = basicPlanet;
		this.orbitalPeriod = new SimpleDoubleProperty(orbitalPeriod);
		this.planetRadiusComparedToEarth = new SimpleDoubleProperty(planetRadiusComparedToEarth);
		this.planetMassComparedToEarth = new SimpleDoubleProperty(planetMassComparedToEarth);
		this.stellarSurfaceGravity = new SimpleDoubleProperty(stellarSurfaceGravity);
		this.distance = new SimpleDoubleProperty(distance);
		
	}
	
	public IntermediatePlanet(IntermediatePlanet other) {
		super(other.basicPlanet);
		
		this.orbitalPeriod = other.orbitalPeriod;
		this.planetRadiusComparedToEarth = other.planetRadiusComparedToEarth;
		this.planetMassComparedToEarth = other.planetMassComparedToEarth;
		this.stellarSurfaceGravity = other.stellarSurfaceGravity;
		this.distance = other.distance;
	}

	public static ArrayList<String> getProperties(){
		
		ArrayList<String> properties = BasicPlanet.getProperties();
		
		properties.add("pl_orbper");
		properties.add("pl_rade");
		properties.add("pl_bmasse");
		properties.add("st_logg");
		properties.add("sy_dist");
		
		return properties;
	}
	
	public double getOrbitalPeriod() {
		return orbitalPeriod.get();
	}
	
	public double getPlanetRadiusComparedToEarth() {
		return planetRadiusComparedToEarth.get();
	}
	
	public double getPlanetMassComparedToEarth() {
		return planetMassComparedToEarth.get();
	}
	
	public double getStellarSurfaceGravity() {
		return stellarSurfaceGravity.get();
	}
	
	public double getDistance() {
		return distance.get();
	}
	
}
