/**
 * Dan Coleman R00151926 Final Project OOProgramming 2 2018
 * 
 * database: deals with all the SQL Query realated stuff in the program
 * NOTE: These were done on the college servers and thus the database will fail on computers outside of the Campus.
 */

package database;

import java.sql.*;


public class database {

	private static Connection connection;
	private static database database;

	private database() { //Constructor 

		try {
			// Connects to DB
			connection = DriverManager.getConnection("jdbc:mysql://157.190.43.7:3306/r00151926?useSSL=false",
					"R00151926", "Spring2018");
			System.out.println("Connected!");

		} catch (Exception ex) { //For Debugging 
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
	//Creates instance of database for Singleton pattern
	public static database getInstance() {

		if (database == null)
			database = new database();

		return database;
	}
	//Gets connection
	public static Connection getConnection() {

		return connection;
	}
	/**
	 * Creates an insert Statement for the SQL and returns if it was successful
	 * @param statement: The query created as a String is passed in
	 * @return returns a boolean to check if statement was successful
	 */
	public static boolean insert(String statement) {

		try {

			Statement state = connection.createStatement();
			state.executeUpdate(statement);
			state.close();
			return true;

		} catch (Exception io) {
			io.printStackTrace();

		}
		return false;
	}
	/**
	 * Returns result set for the query 
	 * @param The query created as a String is passed in
	 * @return returns the result set 
	 */
	
	public static ResultSet queryStatement(String qry) {
		ResultSet returningSet = null;
		
		try {
			Statement stat = connection.createStatement();
			returningSet = stat.executeQuery(qry);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return returningSet;
		
	}

}
