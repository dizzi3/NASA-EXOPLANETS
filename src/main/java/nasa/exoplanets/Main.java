package nasa.exoplanets;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nasa.exoplanets.controllers.MainScreenController;
import nasa.exoplanets.controllers.ResultScreenController;
import nasa.exoplanets.nodes.tables.BasicTable;
import nasa.exoplanets.planets.BasicPlanet;

public class Main extends Application{

	private static Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Main.primaryStage = primaryStage;
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/MainScreen.fxml"));
		
		StackPane stackPane = loader.load();
		
		Scene scene = new Scene(stackPane);
		
		scene.getStylesheets().add(getClass().getResource("/styles/main_screen_styles.css").toExternalForm());
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("NASA EXOPLANETS");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void switchToResultScene(BasicTable table) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/ResultScreen.fxml"));
		
		Parent pane = loader.load();		
		
		ResultScreenController resultController = loader.getController();
		resultController.setTable(table);

		primaryStage.getScene().setRoot(pane);
	}
	
	public static void switchToMainScreen() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/MainScreen.fxml"));
		
		Parent pane = loader.load();		

		primaryStage.getScene().setRoot(pane);
		
	}
	
}
