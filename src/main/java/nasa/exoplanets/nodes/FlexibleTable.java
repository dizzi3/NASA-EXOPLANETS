package nasa.exoplanets.nodes;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.data.structures.Planet;

public class FlexibleTable extends TableView<Planet>{
	
	public static double tableWidth = 0.0;
	private static final double defaultColumnWidth = 170.0;
	
	public FlexibleTable(ObservableList<Planet>data) {
		
		createTableFromData(data);
		
	}
	
	@SuppressWarnings("unchecked")
	private void createTableFromData(ObservableList<Planet>data) {
		
		setEditable(true);
		
		TableColumn<Planet, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(defaultColumnWidth);
		nameColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("name"));
		
		TableColumn<Planet, String> hostNameColumn = new TableColumn<>("Host name");
		hostNameColumn.setMinWidth(defaultColumnWidth);
		hostNameColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("hostName"));

		TableColumn<Planet, String> numberOfStarsColumn = new TableColumn<>("Number of stars");
		numberOfStarsColumn.setMinWidth(defaultColumnWidth);
		numberOfStarsColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("numberOfStars"));

		TableColumn<Planet, String> numberOfPlanetsColumn = new TableColumn<>("Number of planets");
		numberOfPlanetsColumn.setMinWidth(defaultColumnWidth);
		numberOfPlanetsColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("numberOfPlanets"));
		
		TableColumn<Planet, String> discoveryMethodColumn = new TableColumn<>("Discovery method");
		discoveryMethodColumn.setMinWidth(defaultColumnWidth);
		discoveryMethodColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("discoveryMethod"));
		
		TableColumn<Planet, String> discoveryYearColumn = new TableColumn<>("Discovery year");
		discoveryYearColumn.setMinWidth(defaultColumnWidth);
		discoveryYearColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("discoveryYear"));
		
		TableColumn<Planet, String> discoveryFacilityColumn = new TableColumn<>("Discovery facility");
		discoveryFacilityColumn.setMinWidth(defaultColumnWidth + 10);
		discoveryFacilityColumn.setCellValueFactory(new PropertyValueFactory<Planet, String>("discoveryFacility"));
		
		setItems(data);
		getColumns().addAll(nameColumn, hostNameColumn, numberOfStarsColumn,
				numberOfPlanetsColumn, discoveryMethodColumn, discoveryYearColumn,
				discoveryFacilityColumn);
		
		setTableWidth();
	}
	
	private void setTableWidth() {

		tableWidth = 0.0;
		
		for(TableColumn<Planet, ?> s : getColumns())
			tableWidth += s.getMinWidth();
	
	}

}
