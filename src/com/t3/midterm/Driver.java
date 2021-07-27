/**
 *
 */
package com.t3.midterm;

import java.util.Scanner;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * @author Aidan, Jacob, Brian
 *
 */
public class Driver {
	public static final Scanner kb = new Scanner(System.in);
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
	public static final String USER = "root";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.printf("Enter password for %s on %s\n", USER, DB_URL);
			String password = kb.nextLine();
			DataSource db = createDS(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		kb.close();
	}
	
	private static DataSource createDS(String password) {
		MysqlDataSource db = new MysqlDataSource();
		
		db.setURL(DB_URL);   
		db.setUser(USER);
		db.setPassword(password);
		
		return db;
	}

	

}
