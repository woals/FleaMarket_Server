package com.yinyxn.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {//∑√Œ  ˝æ›ø‚Bean
	private static Connection con = null ;
	public static Connection getConnetion(){
		if(con == null){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:ORCL" ;
				con = DriverManager.getConnection(url,"scott","1221");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con ;
	}

}
