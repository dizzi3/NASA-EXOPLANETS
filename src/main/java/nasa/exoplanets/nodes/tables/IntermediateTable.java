package nasa.exoplanets.nodes.tables;

import javafx.collections.ObservableList;
import nasa.exoplanets.planets.BasicPlanet;

public class IntermediateTable extends BasicTable{

	public IntermediateTable(ObservableList<BasicPlanet> data) {
		super(data);
	}
	
	@Override
	protected void addColumns() {
		
		super.addColumns();

		addColumn("Orbital Period [Days]", "orbitalPeriod");
		addColumn("Planet Radius [Earth Radius]", "planetRadiusComparedToEarth", 250.0);
		addColumn("Planet Mass [Earth Mass]", "planetMassComparedToEarth");
		addColumn("Stellar Surface Gravity", "stellarSurfaceGravity");
		addColumn("Distance [Parsec]", "distance");
		
	}

}
