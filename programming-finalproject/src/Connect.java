import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A simple data source for getting database connections.
 */
public class Connect {
	private static String url;
	private static String username;
	private static String password;

	/**
	 * Gets a connection to the database.
	 * 
	 * @return the database connection
	 */
	public static Connection getConnection() throws SQLException {
		String server = "jdbc:mysql://140.119.19.79/";
		String database = "MG04";
		url = server + database;
		username = "MG04";
		password = "ifc789";
		return DriverManager.getConnection(url, username, password);
	}
}