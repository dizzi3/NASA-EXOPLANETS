package nasa.exoplanets;

import org.json.JSONObject;

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
		
		//TODO: implement styles
		//scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("NASA EXOPLANETS");
		primaryStage.setResizable(false);
		primaryStage.show();
		
		
		JSONObject jsonObj = JSON.readFromURL("https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=select+pl_name,pl_masse,ra,dec+from+ps+where+upper(soltype)+like+%27%CONF%%27+and+pl_masse+between+0.5+and+2.0&format=json").getJSONObject(0); 
		System.out.println(jsonObj.toString());
	}
	
}
