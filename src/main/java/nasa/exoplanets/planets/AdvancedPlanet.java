package nasa.exoplanets.planets;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AdvancedPlanet extends IntermediatePlanet{

	private SimpleIntegerProperty controversialFlag;
	private SimpleDoubleProperty orbitSemiMajorAxis;
	private SimpleDoubleProperty planetRadiusComparedToJupiter;
	private SimpleDoubleProperty planetMassComparedToJupiter;
	private SimpleStringProperty planetMassProvenance;
	private SimpleDoubleProperty eccentricity;
	private SimpleDoubleProperty insolationFlux;
	private SimpleDoubleProperty equilibriumTemperature;
	private SimpleIntegerProperty dataShowTransitTimingVariations;
	private SimpleStringProperty spectralType;
	private SimpleDoubleProperty stellarEffectiveTemperature;
	private SimpleDoubleProperty stellarRadius;
	private SimpleDoubleProperty stellarMass;
	private SimpleDoubleProperty stellarMetallicity;
	private SimpleStringProperty stellarMetallicityRatio;
	private SimpleStringProperty RA;
	private SimpleStringProperty Dec;
	private SimpleDoubleProperty VJohnsonMagnitude;
	private SimpleDoubleProperty Ks2MASSMagnitude;
	private SimpleDoubleProperty GaiaMagnitude;
	
	public AdvancedPlanet(IntermediatePlanet intermediatePlanet, int controversialFlag, double orbitSemiMajorAxis,
			double planetRadiusComparedToJupiter, double planetMassComparedToJupiter, String planetMassProvenance,
			double eccentricity, double insolationFlux, double equilibriumTemperature, int dataShowTransitTimingVariations,
			String spectralType, double stellarEffectiveTemperature, double stellarRadius, double stellarMass,
			double stellarMetallicity, String stellarMetallicityRatio, String RA, String Dec, double VJohnsonMagnitude,
			double Ks2MASSMagnitude, double GaiaMagnitude) {
		super(intermediatePlanet);

		this.controversialFlag = new SimpleIntegerProperty(controversialFlag);
		this.orbitSemiMajorAxis = new SimpleDoubleProperty(orbitSemiMajorAxis);
		this.planetRadiusComparedToJupiter = new SimpleDoubleProperty(planetRadiusComparedToJupiter);
		this.planetMassComparedToJupiter = new SimpleDoubleProperty(planetMassComparedToJupiter);
		this.planetMassProvenance = new SimpleStringProperty(planetMassProvenance);
		this.eccentricity = new SimpleDoubleProperty(eccentricity);
		this.insolationFlux = new SimpleDoubleProperty(insolationFlux);
		this.equilibriumTemperature = new SimpleDoubleProperty(equilibriumTemperature);
		this.dataShowTransitTimingVariations = new SimpleIntegerProperty(dataShowTransitTimingVariations);
		this.spectralType = new SimpleStringProperty(spectralType);
		this.stellarEffectiveTemperature = new SimpleDoubleProperty(stellarEffectiveTemperature);
		this.stellarRadius = new SimpleDoubleProperty(stellarRadius);
		this.stellarMass = new SimpleDoubleProperty(stellarMass);
		this.stellarMetallicity = new SimpleDoubleProperty(stellarMetallicity);
		this.stellarMetallicityRatio = new SimpleStringProperty(stellarMetallicityRatio);
		this.RA = new SimpleStringProperty(RA);
		this.Dec = new SimpleStringProperty(Dec);
		this.VJohnsonMagnitude = new SimpleDoubleProperty(VJohnsonMagnitude);
		this.Ks2MASSMagnitude = new SimpleDoubleProperty(Ks2MASSMagnitude);
		this.GaiaMagnitude = new SimpleDoubleProperty(GaiaMagnitude);
	}

	public static ArrayList<String> getProperties(){
		
		ArrayList<String> properties = IntermediatePlanet.getProperties();
	
		properties.add("pl_controv_flag");
		properties.add("pl_orbsmax");
		properties.add("pl_radj");
		properties.add("pl_bmassj");
		properties.add("pl_bmassprov");
		properties.add("pl_orbeccen");
		properties.add("pl_insol");
		properties.add("pl_eqt");
		properties.add("ttv_flag");
		properties.add("st_spectype");
		properties.add("st_teff");
		properties.add("st_rad");
		properties.add("st_mass");
		properties.add("st_met");
		properties.add("st_metratio");
		properties.add("rastr");
		properties.add("decstr");
		properties.add("sy_vmag");
		properties.add("sy_kmag");
		properties.add("sy_gaiamag");
		
		return properties;
	}
	
	public int getControversialFlag() {
		return controversialFlag.get();
	}
	
	public double getOrbitSemiMajorAxis() {
		return orbitSemiMajorAxis.get();
	}
	
	public double getPlanetRadiusComparedToJupiter() {
		return planetRadiusComparedToJupiter.get();
	}
	
	public double getPlanetMassComparedToJupiter() {
		return planetMassComparedToJupiter.get();
	}
	
	public String getPlanetMassProvenance() {
		return planetMassProvenance.get();
	}
	
	public double getEccentricity() {
		return eccentricity.get();
	}
	
	public double getInsolationFlux() {
		return insolationFlux.get();
	}
	
	public double getEquilibriumTemperature() {
		return equilibriumTemperature.get();
	}
	
	public int getDataShowTransitTimingVariations() {
		return dataShowTransitTimingVariations.get();
	}
	
	public String getSpectralType() {
		return spectralType.get();
	}
	
	public double getStellarEffectiveTemperature() {
		return stellarEffectiveTemperature.get();
	}
	
	public double getStellarRadius() {
		return stellarRadius.get();
	}
	
	public double getStellarMass() {
		return stellarMass.get();
	}
	
	public double getStellarMetallicity() {
		return stellarMetallicity.get();
	}
	
	public String getStellarMetallicityRatio() {
		return stellarMetallicityRatio.get();
	}
	
	public String getRA() {
		return RA.get();
	}
	
	public String getDec() {
		return Dec.get();
	}
	
	public double getVJohnsonMagnitude() {
		return VJohnsonMagnitude.get();
	}
	
	public double getKs2MASSMagnitude() {
		return Ks2MASSMagnitude.get();
	}
	
	public double getGaiaMagnitude() {
		return GaiaMagnitude.get();
	}
	
}
