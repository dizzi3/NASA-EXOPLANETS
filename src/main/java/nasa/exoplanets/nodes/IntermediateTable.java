package nasa.exoplanets.nodes;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.planets.BasicPlanet;

public class IntermediateTable extends BasicTable{

	public IntermediateTable(ObservableList<BasicPlanet> data) {
		super(data);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addColumns() {
		
		super.addColumns();
		
		TableColumn<BasicPlanet, String> orbitalPeriodColumn = new TableColumn<>("Orbital period");
		orbitalPeriodColumn.setMinWidth(defaultColumnWidth);
		orbitalPeriodColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("orbitalPeriod"));
		
		TableColumn<BasicPlanet, String> radiusComparedToEarthColumn = new TableColumn<>("Planet radius [Earth radius]");
		radiusComparedToEarthColumn.setMinWidth(defaultColumnWidth + 50);
		radiusComparedToEarthColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("planetRadiusComparedToEarth"));
		
		getColumns().addAll(orbitalPeriodColumn, radiusComparedToEarthColumn);

		
	}

}
