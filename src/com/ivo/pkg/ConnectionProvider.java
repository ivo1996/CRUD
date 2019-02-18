package com.ivo.pkg;
import java.sql.*;

public class ConnectionProvider implements Provider{

	static Connection con=null;
	
	//method for connection initialization.
	public static Connection getCon() {
		try {
			
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(connURL,username,pwd);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return con;
	}

}
