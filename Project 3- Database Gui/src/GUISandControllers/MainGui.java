/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * Rebuilt Object Based Ordering System to function with Guis and a database
 * Was given one week so excuse the lack of polish 
 * Need to update with Validation soon
 * 
 * MAINGUI: Loads in the Gui from scenebuilder
 */
package GUISandControllers;

import java.io.IOException;

import database.database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException{
		Parent gui = null; //Creates Parent
		gui = FXMLLoader.load(getClass().getResource("MainPage.fxml")); //Loads up fmxl file
		primaryStage.setTitle("Dan Coleman R00151926 Project 3"); //Names Primary Stage 
		primaryStage.setScene(new Scene(gui, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
		
		database.getInstance(); //Singleton Pattern
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
