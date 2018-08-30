package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	  public Connection connection ;
	  PropertiesReader dataDB = new PropertiesReader();
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (connection == null || connection.isClosed()) {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connection = DriverManager.getConnection(dataDB.getHostDwh(), dataDB.getUserDwh(), dataDB.getPassDwh());
		}
		return connection;
	}
}
