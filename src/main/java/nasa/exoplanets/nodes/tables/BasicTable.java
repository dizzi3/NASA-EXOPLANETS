package nasa.exoplanets.nodes.tables;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.planets.BasicPlanet;

public class BasicTable extends TableView<BasicPlanet>{
	
	public static double tableWidth = 0.0;
	protected static final double defaultColumnWidth = 250.0;
	public static final double sideMargins = 50.0;
	
	public BasicTable(ObservableList<BasicPlanet>data) {
		createTableFromData(data);
	}
	
	private void createTableFromData(ObservableList<BasicPlanet>data) {
		
		setEditable(true);
		
		addColumns();
		
		setItems(data);
		
		setTableWidth();
	}
	
	protected void addColumns() {
		
		addColumn("Planet Name", "name");
		addColumn("Host Name", "hostName");
		addColumn("Number Of Stars", "numberOfStars");
		addColumn("Number Of Planets", "numberOfPlanets", 250);
		addColumn("Discovery Method", "discoveryMethod");
		addColumn("Discovery Year", "discoveryYear");
		addColumn("Discovery Facility", "discoveryFacility", 360.0);
		
	}
	
	protected void addColumn(String name, String property) {
		
		TableColumn<BasicPlanet, String> column = new TableColumn<>(name);
		column.setMinWidth(defaultColumnWidth);
		column.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>(property));
		
		getColumns().add(column);
	}
	
	protected void addColumn(String name, String property, double columnWidth) {
		
		TableColumn<BasicPlanet, String> column = new TableColumn<>(name);
		column.setMinWidth(columnWidth);
		column.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>(property));
		
		getColumns().add(column);
	}
	
	protected void addColumnAt(String name, String property, int index) {
		
		TableColumn<BasicPlanet, String> column = new TableColumn<>(name);
		column.setMinWidth(defaultColumnWidth);
		column.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>(property));
		
		getColumns().add(index, column);
	}
	
	protected void addColumnAt(String name, String property, int index, double columnWidth) {
		
		TableColumn<BasicPlanet, String> column = new TableColumn<>(name);
		column.setMinWidth(columnWidth);
		column.setCellValueFactory(new PropertyValueFactory<BasicPlanet, String>(property));
		
		getColumns().add(index, column);
	}
	
	private void setTableWidth() {

		tableWidth = 0.0;
		
		for(TableColumn<BasicPlanet, ?> s : getColumns())
			tableWidth += s.getMinWidth();
	
	}

}
