package nasa.exoplanets.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import nasa.exoplanets.Main;
import nasa.exoplanets.nodes.tables.BasicTable;

public class ResultScreenController {

	@FXML
	private StackPane tableStackPane;
	
	public void setTable(BasicTable table) {
		tableStackPane.getChildren().add(table);
	}
	
	public void OnBackButtonClick() throws IOException {
		Main.switchToMainScreen();
	}
	
}
