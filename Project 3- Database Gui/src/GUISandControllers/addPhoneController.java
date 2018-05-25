/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * addPhoneController: Adds a phone to the database
 */
package GUISandControllers;

import java.io.IOException;

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

public class addPhoneController {
	//--------------------
	//SceneBuilder id Tags
	//--------------------
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField make;
	@FXML
	TextField model;
	@FXML
	TextField description;
	@FXML
	TextField price;
	@FXML
	TextField storage;
	@FXML
	TextArea info;
	//------------------
	//Methods
	//------------------
	@FXML
	public void submit(ActionEvent submit) {
		// Adds product to Database
		try {
			// Creates Statement
			String ins = "Insert into products (make, model, price, storage) values ('" + make.getText() + "', '"
					+ model.getText() + "', '" + price.getText() + "', '" + storage.getText() + "')";

			// Executes Statement
			database.insert(ins);

			// For Testing
			// int res = insertStmt.executeUpdate(insertSQL);
			// System.out.println("The Number or records inserted is " +res);

			// Shows user the prod added
			info.setText("Product: " + "\n Make: " + make.getText() + "\n Model: " + model.getText()
					+ "\n Price:€" + price.getText() + "\n Storage: " + storage.getText() + " GB");

			// Increments prodID
			//prodID += 1;

			// Ends Statement
		} catch (Exception io) {
			io.printStackTrace();
		}
		;
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