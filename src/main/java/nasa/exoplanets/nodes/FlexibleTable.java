package nasa.exoplanets.nodes;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.helpers.MainScreenUIHelper.DATA_AMOUNT;
import nasa.exoplanets.planets.BasicPlanet;
import nasa.exoplanets.query.Query.DATA_TYPE;

public class FlexibleTable extends TableView<BasicPlanet>{
	
	public static double tableWidth = 0.0;
	private static final double defaultColumnWidth = 170.0;
	private DATA_AMOUNT dataAmount;
	
	public FlexibleTable(ObservableList<BasicPlanet>data, DATA_AMOUNT dataAmount) {
		
		this.dataAmount = dataAmount;
		createTableFromData(data);
		
	}
	
	@SuppressWarnings("unchecked")
	private void createTableFromData(ObservableList<BasicPlanet>data) {
		
		setEditable(true);
		
		addBasicColumns();
		addIntermediateColumns();
		
		setItems(data);
		
		setTableWidth();
	}
	
	@SuppressWarnings("unchecked")
	private void addBasicColumns() {
		
		TableColumn<BasicPlanet, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(defaultColumnWidth);
		nameColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("name"));
		
		TableColumn<BasicPlanet, String> hostNameColumn = new TableColumn<>("Host name");
		hostNameColumn.setMinWidth(defaultColumnWidth);
		hostNameColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("hostName"));

		TableColumn<BasicPlanet, String> numberOfStarsColumn = new TableColumn<>("Number of stars");
		numberOfStarsColumn.setMinWidth(defaultColumnWidth);
		numberOfStarsColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("numberOfStars"));

		TableColumn<BasicPlanet, String> numberOfPlanetsColumn = new TableColumn<>("Number of planets");
		numberOfPlanetsColumn.setMinWidth(defaultColumnWidth);
		numberOfPlanetsColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("numberOfPlanets"));
		
		TableColumn<BasicPlanet, String> discoveryMethodColumn = new TableColumn<>("Discovery method");
		discoveryMethodColumn.setMinWidth(defaultColumnWidth);
		discoveryMethodColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("discoveryMethod"));
		
		TableColumn<BasicPlanet, String> discoveryYearColumn = new TableColumn<>("Discovery year");
		discoveryYearColumn.setMinWidth(defaultColumnWidth);
		discoveryYearColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("discoveryYear"));
		
		TableColumn<BasicPlanet, String> discoveryFacilityColumn = new TableColumn<>("Discovery facility");
		discoveryFacilityColumn.setMinWidth(defaultColumnWidth);
		discoveryFacilityColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("discoveryFacility"));
		
		getColumns().addAll(nameColumn, hostNameColumn, numberOfStarsColumn,
				numberOfPlanetsColumn, discoveryMethodColumn, discoveryYearColumn,
				discoveryFacilityColumn);
		
	}
	
	@SuppressWarnings("unchecked")
	private void addIntermediateColumns() {
		
		if(!(dataAmount == DATA_AMOUNT.INTERMEDIATE) && !(dataAmount == DATA_AMOUNT.ADVANCED))
			return;
		
		TableColumn<BasicPlanet, String> orbitalPeriodColumn = new TableColumn<>("Orbital period");
		orbitalPeriodColumn.setMinWidth(defaultColumnWidth);
		orbitalPeriodColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("orbitalPeriod"));
		
		TableColumn<BasicPlanet, String> radiusComparedToEarthColumn = new TableColumn<>("Planet radius [Earth radius]");
		radiusComparedToEarthColumn.setMinWidth(defaultColumnWidth + 50);
		radiusComparedToEarthColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("planetRadiusComparedToEarth"));
		
		getColumns().addAll(orbitalPeriodColumn, radiusComparedToEarthColumn);
	}
	
	private void setTableWidth() {

		tableWidth = 0.0;
		
		for(TableColumn<BasicPlanet, ?> s : getColumns())
			tableWidth += s.getMinWidth();
	
	}

}
