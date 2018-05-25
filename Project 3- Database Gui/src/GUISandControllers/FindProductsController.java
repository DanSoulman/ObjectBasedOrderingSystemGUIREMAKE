/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * FindProductsController: Finds a product by its product ID
 */

package GUISandControllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FindProductsController {
	//--------------------
	//SceneBuilder id Tags
	//--------------------
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField prodNo;
	@FXML
	TextArea prodList;
	//------------------
	//Methods
	//------------------
	@FXML
	public void submit(ActionEvent submit) { //Finds the Product of a given ID
		String id = prodNo.getText();
		String text = "";
		// Creates Statement
		String querySQL = "Select * from products where prodId = ' " + id + "';";

		// Executes Statement
		ResultSet ret = database.queryStatement(querySQL);
		
		try {
			while(ret.next()) {     //While theres more in the set
				text += "ProdNo:\t" + ret.getInt("prodID") + "\n";
				text += "Make:\t" + ret.getString("make") + "\n";
				text += "Model:\t" + ret.getString("model") + "\n";
				text += "Price:\t€" +ret.getString("price") + "\n";
				text += "Storage:\t" + ret.getString("storage") + "GB\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
			// Displays text
			prodList.setText(text);
		}


	@FXML
	public void back(ActionEvent back) { //returns to MainPage
		Parent bck = null; // Creates Parent
		try {
			bck = FXMLLoader.load(getClass().getResource("MainPage.fxml"));// Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * getting the source of the action event, Casting it to a node Getting the
		 * scene from that, From the scene getting the window And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) back.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(bck, 600, 400)); // Sets scene to size
		primaryStage.setResizable(false);// Disables changing it's size
		primaryStage.show();// Show stage
	}
}
