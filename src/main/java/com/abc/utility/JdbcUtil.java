package com.abc.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static Connection connection;

	static {
		Properties properties = new Properties();

		String filePath = "C:\\Users\\Jeevika\\eclipse-workspace\\HttpSessionTracking\\src\\main\\java\\com\\abc\\properties\\application.properties";

		FileInputStream fis;

		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);

			String url = properties.getProperty("jdbc.url");
			String userName = properties.getProperty("jdbc.userName");
			String password = properties.getProperty("jdbc.password");

			connection = DriverManager.getConnection(url, userName, password);

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getDbConnection() {
		return connection;
	}

	// Closing all the resources
	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		// Closing JDBC resources
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
