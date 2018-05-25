/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * orderProductsController: Allows player to place an order for a Product
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

public class orderProductsController {
	//--------------------
	//SceneBuilder id Tags
	//--------------------
	@FXML
	Button submit;
	@FXML
	Button back;
	@FXML
	TextField custName;
	@FXML
	TextField custAddress;
	@FXML
	TextField prodID;
	@FXML
	TextField quantity;
	@FXML
	TextArea info;

	//------------------
	//Methods
	//------------------
	@FXML
	public void submit(ActionEvent submit) {
		// Adds product to Database
		 try {
	            //Creates Statement 
	            String ins = "Insert into orders (name, address, prodID, quantity) values ('" + custName.getText() + "', '"
						+ custAddress.getText() + "', '" + prodID.getText() + "', '" + quantity.getText() + "')";
	            
	            //Executes Statement
	            database.insert(ins);
	            
	            //For Testing
	            //int res = insertStmt.executeUpdate(insertSQL);
	            //System.out.println("The Number or records inserted is      " +res);
	            
	            //Shows user the ord added
	            info.setText("Customer name: " + custName.getText()+ "\nCustomer Address: "+ custAddress.getText()+ "\nProductID: " 
	            + prodID.getText()+ "\nquantity: " + quantity.getText());
	          
	            //Ends Statement
	       }catch (Exception io) {
	                System.out.println("error"+io);
	       };   
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