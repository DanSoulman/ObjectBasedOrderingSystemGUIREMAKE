/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * HomeController: Switches between panes to correct gui
 */

package GUISandControllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {
	//--------------------
	//SceneBuilder id Tags
	//--------------------
	@FXML
	Button addPhone;
	@FXML
	Button displayProd;
	@FXML
	Button displayOrder;
	@FXML
	Button findProd;
	@FXML
	Button orderProd;
	@FXML
	Button quit;
	@FXML
	//------------------
	//Methods
	//------------------
	//THE FOLLOWING METHODS ALL SWTICH PANES TO THE CORRECT PANE
	
	public void addPhone(ActionEvent addPhone) {
		
		Parent phone = null; //Creates Parent
		try {
			phone = FXMLLoader.load(getClass().getResource("addPhone.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) addPhone.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(phone, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void displayProd(ActionEvent displayProd) {
		Parent dp = null; //Creates Parent
		try {
			dp = FXMLLoader.load(getClass().getResource("DisplayProducts.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) displayProd.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(dp, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void displayOrder(ActionEvent displayOrder) {
		Parent dOr = null; //Creates Parent
		try {
			dOr = FXMLLoader.load(getClass().getResource("Display orders.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) displayOrder.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(dOr, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void findProd(ActionEvent findProd) {
		Parent find = null; //Creates Parent
		try {
			find = FXMLLoader.load(getClass().getResource("FindProds.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) findProd.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(find, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void orderProd(ActionEvent orderProd) {
		Parent op = null; //Creates Parent
		try {
			op = FXMLLoader.load(getClass().getResource("OrderProducts.fxml"));//Loads up fmxl file
		} catch (IOException e) {
			e.printStackTrace();
		} 
		/*getting the source of the action event, Casting it to a node
		 *Getting the scene from that, From the scene getting the window
		 *And casting it to stage
		 */
		Stage primaryStage = (Stage) ((Node) orderProd.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(op, 600, 400)); //Sets scene to size
		primaryStage.setResizable(false);//Disables changing it's size
		primaryStage.show();//Show stage
	}
	@FXML
	public void quit(ActionEvent quit) {
		Platform.exit();
	}

}
