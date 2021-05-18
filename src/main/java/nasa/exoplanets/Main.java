package nasa.exoplanets;

import org.json.JSONArray;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nasa.exoplanets.helpers.JSON;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
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
	
}
