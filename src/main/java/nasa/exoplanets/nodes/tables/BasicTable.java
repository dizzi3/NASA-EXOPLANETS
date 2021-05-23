package nasa.exoplanets.nodes.tables;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nasa.exoplanets.planets.BasicPlanet;

public class BasicTable extends TableView<BasicPlanet>{
	
	public static double tableWidth = 0.0;
	protected static final double defaultColumnWidth = 170.0;
	
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
		
		addColumn("Name", "name");
		addColumn("Host name", "hostName");
		addColumn("Number of stars", "numberOfStars");
		addColumn("Number of planets", "numberOfPlanets");
		addColumn("Discovery method", "discoveryMethod");
		addColumn("Discovery year", "discoveryYear");
		addColumn("Discovery facility", "discoveryFacility", 300.0);
		
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
	
	private void setTableWidth() {

		tableWidth = 0.0;
		
		for(TableColumn<BasicPlanet, ?> s : getColumns())
			tableWidth += s.getMinWidth();
	
	}

}
