package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	
	public static void main(String args[]) {
		
		try{
			//Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//creating connection
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","username","password");

			Statement s=con.createStatement();      //creating statement

			ResultSet rs=s.executeQuery("select * from Student");   //executing statement

			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}

			con.close();    //closing connection
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
