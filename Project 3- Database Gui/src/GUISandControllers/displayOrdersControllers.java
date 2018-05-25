/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * displayOrdersController: Shows all current orders
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

public class displayOrdersControllers {
	//--------------------
	//SceneBuilder id Tags
	//--------------------
	@FXML
	TextField custName;
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextArea info;
	//------------------
	//Methods
	//------------------
	@FXML
	public void initialize() {//Loads up the information upon switching to this pane
		// Creates Statement
		String querySQL = "Select * from orders;";

		// Executes Statement
		ResultSet ret = database.queryStatement(querySQL);
		String text = "";

		try {
			while (ret.next()) {
				text += "OrdNo:\t" + ret.getInt("orderNo") + "\n";
				text += "Name:\t" + ret.getString("name") + "\n";
				text += "Address:\t" + ret.getString("address") + "\n";
				text += "ProdID:\t" + ret.getString("prodID") + "\n";
				text += "Quantity:\t" + ret.getString("quantity") + "\n\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Displays text
		info.setText(text);
	}


	@FXML
	public void back(ActionEvent back) {//returns to MainPage
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
