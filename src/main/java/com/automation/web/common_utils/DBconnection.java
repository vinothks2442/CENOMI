/**
 * @author Manojprabakaran
   Methods - 

/***************************************************/

package com.automation.web.common_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBconnection {

	public ArrayList<String> list = new ArrayList<String>();
	public ArrayList<String> rowslist = new ArrayList<String>();
	public ArrayList<String> dataTypeList = new ArrayList<String>();
	public ArrayList<String> dataTypelenghtList = new ArrayList<String>();
	public ArrayList<String> columnDatalist = new ArrayList<String>();
	public ArrayList<String> columnList = new ArrayList<String>();
	public int columnCount;

	public String handle;
	public Statement stmt;
	public ResultSet rs;
	public Connection con;

//	public String ConnectDBGetdata(String dBURL, String dBName, String dBPassword, String dBUserName, String Query01,
//			String DataColumnName) throws Throwable {
//
//		// Create a variable for the connection string.
//		String connectionUrl = "jdbc:sqlserver://" + dBURL + ";DatabaseName= " + dBName + ";user=" + dBUserName
//				+ ";password=" + dBPassword + "";
//
//		con = DriverManager.getConnection(connectionUrl);
//		stmt = con.createStatement();
//		String SQLResult = null;
//		String SQL = Query01;
//		rs = stmt.executeQuery(SQL);
//		while (rs.next()) {
//			SQLResult = rs.getString(DataColumnName);
//			System.out.println(SQLResult);
//
//		}
//		con.close();
//		return SQLResult;
//	}
//
//	

	public void ConnectDBUpdatedata(String dBURL, String dBName, String dBPassword, String dBUserName, String Query01)
			throws Throwable {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://" + dBURL + ";DatabaseName= " + dBName + ";user=" + dBUserName
				+ ";password=" + dBPassword + "";

		con = DriverManager.getConnection(connectionUrl);
		stmt = con.createStatement();
		String SQLResult = null;
		String SQL = Query01;
		stmt.execute(SQL);
		con.close();

	}

//------------------------------------------------------------------------------------------------------------------------------------------------

	/*--------------------Craated below SQL method to get value from query if results doesnt have any column name Ex: count of rows */
	public String ConnectDBGetdatawithoutDatacolumnname(String dBURL, String dBName, String dBPassword,
			String dBUserName, String Query01) throws Throwable {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://" + dBURL + ";DatabaseName= " + dBName + ";user=" + dBUserName
				+ ";password=" + dBPassword + "";

		con = DriverManager.getConnection(connectionUrl);
		stmt = con.createStatement();
		String SQLResult = null;
		String SQL = Query01;
		rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			SQLResult = rs.getString(1);
			System.out.println(SQLResult);

		}
		con.close();
		return SQLResult;
	}

	public String ConnectDBGetdata(String dBURL, String dBName, String dBPassword, String dBUserName, String Query01,
			String DataColumnName) throws Throwable {

		// Create a variable for the connection string.
		String connectionUrl = dBURL + "/" + dBName;
		con = DriverManager.getConnection(connectionUrl, dBUserName, dBPassword);
		stmt = con.createStatement();
		String SQLResult = null;
		String SQL = Query01;
		rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			SQLResult = rs.getString(DataColumnName);
			System.out.println(SQLResult);

		}
		con.close();
		return SQLResult;
	}

	/*------------------------------DB Method to get Data---------------------------------------------------*/
	public String ConnectDB_VerifyColums(String dBURL, String dBName, String dBPassword, String dBUserName,
			String Query, String col1, String col2, String col3) throws Throwable {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://" + dBURL + ";DatabaseName= " + dBName + ";user=" + dBUserName
				+ ";password=" + dBPassword + "";

		con = DriverManager.getConnection(connectionUrl);
		stmt = con.createStatement();
		String SQLResult = null;
		String SQL = Query;
		rs = stmt.executeQuery(SQL);
		while (rs.next()) {
			SQLResult = rs.getString(col1);
			SQLResult = rs.getString(col2);
			System.out.println("col1 " + rs.getString(col1));
			System.out.println("col2  " + rs.getString(col2));
			System.out.println("Row " + rs.getRow());// Entire row

			System.out.println("CusAccountNAICSCodeID :" + rs.getString(1) + " ,AccountID" + rs.getString(2)
					+ " , NAICSCodeID :" + rs.getString(3));
		}
		con.close();
		return SQLResult;
	}

	public String RetrivingDataFromEmployeeTable(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			list.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String RowsCountFromEmployeeTable(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			rowslist.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String Retriving_DataType(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			dataTypeList.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String Retriving_DataType_Lenght(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			dataTypelenghtList.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String NullCheck(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			dataTypelenghtList.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String RetrivingtargetDataFromEmployeeTable(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			columnDatalist.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String getConstrain(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			dataTypelenghtList.add(SQLResult);
			System.out.println("Sql reults:" + SQLResult);

		}
		connection.close();
		return SQLResult;
	}

	public String RetrivingColumnsFromEmployeeTable(String Query, String ColumnName) throws SQLException {
		String url = ConfigReader.getValue("DbUrl") + "/" + ConfigReader.getValue("DbName");
		String username = ConfigReader.getValue("userName");
		String password = ConfigReader.getValue("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		stmt = connection.createStatement();
		String SQLResult = null;
		rs = stmt.executeQuery(Query);
		while (rs.next()) {
			SQLResult = rs.getString(ColumnName);
			if (SQLResult.equalsIgnoreCase("EMP_ID")) {

			} else {
				columnList.add(SQLResult);
				System.out.println("Sql reults:" + SQLResult);
				columnCount++;
			}
		}
		connection.close();
		return SQLResult;
	}
}
