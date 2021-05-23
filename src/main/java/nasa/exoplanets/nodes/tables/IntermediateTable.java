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

		addColumn("Orbital period", "orbitalPeriod");
		addColumn("Planet radius [Earth radius]", "planetRadiusComparedToEarth", 250.0);
		
	}

}
