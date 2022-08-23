package com.emp.model;

import java.sql.*;

public class EmpDb {
	private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static String DB_URL = "jdbc:mysql://localhost:3306/restaurant?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
	private static String DB_URL = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Asia/Taipei";
	private static String USER = "root";
	private static String PASS = "root";
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if (null == conn) {
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
}
/* */