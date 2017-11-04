package com.syntel.br.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static  String username="system";
	private static  String password="vyas2011";
	
	static{
		
		try {
				Class.forName(driver);
				System.out.println("Driver Loaded..");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void close(Connection con){
		
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
	}	
}
