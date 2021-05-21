package nasa.exoplanets.nodes;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.planets.BasicPlanet;

public class FlexibleTable extends TableView<BasicPlanet>{
	
	public static double tableWidth = 0.0;
	private static final double defaultColumnWidth = 170.0;
	
	public FlexibleTable(ObservableList<BasicPlanet>data) {
		
		createTableFromData(data);
		
	}
	
	@SuppressWarnings("unchecked")
	private void createTableFromData(ObservableList<BasicPlanet>data) {
		
		setEditable(true);
		
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
		discoveryFacilityColumn.setMinWidth(defaultColumnWidth + 10);
		discoveryFacilityColumn.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>("discoveryFacility"));
		
		setItems(data);
		getColumns().addAll(nameColumn, hostNameColumn, numberOfStarsColumn,
				numberOfPlanetsColumn, discoveryMethodColumn, discoveryYearColumn,
				discoveryFacilityColumn);
		
		setTableWidth();
	}
	
	private void setTableWidth() {

		tableWidth = 0.0;
		
		for(TableColumn<BasicPlanet, ?> s : getColumns())
			tableWidth += s.getMinWidth();
	
	}

}
