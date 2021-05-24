package nasa.exoplanets.nodes.tables;

import javafx.collections.ObservableList;
import nasa.exoplanets.planets.BasicPlanet;

public class AdvancedTable extends IntermediateTable{

	public AdvancedTable(ObservableList<BasicPlanet> data) {
		super(data);
	}

	@Override
	protected void addColumns() {
		
		super.addColumns();
		
		addColumnAt("Controversial Flag", "controversialFlag", 7);
		addColumnAt("Orbit Semi-Major Axis [au]", "orbitSemiMajorAxis", 9, 250);
		addColumnAt("Planet Radius [Jupiter Radius]", "planetRadiusComparedToJupiter", 11, 250);
		addColumnAt("Planet Mass [Jupiter Mass]", "planetMassComparedToJupiter", 13);
		addColumnAt("Planet Mass Provenance", "planetMassProvenance", 14);
		addColumnAt("Eccentricity", "eccentricity", 15);
		addColumnAt("Insolation Flux [Earth Flux]", "insolationFlux", 16);
		addColumnAt("Equilibrium Temperature [K]", "equilibriumTemperature", 17, 250);
		addColumnAt("Data Show Transit Timing Variations", "dataShowTransitTimingVariations", 18, 280);
		addColumnAt("Spectral Type", "spectralType", 19);
		addColumnAt("Stellar Effective Temperature [K]", "stellarEffectiveTemperature", 20, 250);
		addColumnAt("Stellar Radius [Solar Radius]", "stellarRadius", 21);
		addColumnAt("Stellar Mass [Solar Mass]", "stellarMass", 22);
		addColumnAt("Stellar Metallicity [dex]", "stellarMetallicity", 23);
		addColumnAt("Stellar Metallicity Ratio", "stellarMetallicityRatio", 24);
		addColumnAt("RA [sexagesimal]", "RA", 26);
		addColumnAt("Dec [sexagesimal]", "Dec", 27);
		addColumnAt("V (Johnson) Magnitude", "VJohnsonMagnitude", 29);
		addColumnAt("Ks (2MASS) Magnitude", "Ks2MASSMagnitude", 30);
		addColumnAt("Gaia Magnitude", "GaiaMagnitude", 31);
		
	}
	
}
