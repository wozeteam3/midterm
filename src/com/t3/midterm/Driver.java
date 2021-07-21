/**
 * 
 */
package com.t3.midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import net.efabrika.util.DBTablePrinter;

/**
 * @author Aidan, Jacob, Brian
 *
 */
public class Driver {
	public static final Scanner kb = new Scanner(System.in);
	
	public static void welcomeMenu() {
		System.out.println("Welcome to Oh, CRUD");
		System.out.println("Oh, CRUD allows you to create, read, update, and delete data in a database.\nPress enter to continue");
		String r = kb.nextLine();
		boolean t = true;
		while (t = true) {
			System.out.println("            Oh Crud!      ");
			System.out.println("  Create Update Read Delete");
			System.out.println("Type the word or letter of what you would like to do?");
			System.out.println("For example if I want to delete a piece of data I would type Delete or d (casing doesn't matter) ");
			Scanner myObj = new Scanner(System.in);
			String enter = myObj.nextLine();
			String choice = enter.toLowerCase();
			if (choice.equals("create") || choice.equals("c")) {
				;
		
			}
			else if (choice.equals("update") || choice.equals("u")) {
				;
		
			}
			else if (choice.equals("read") || choice.equals("r")) {
				;
		
			}
			else if (choice.equals("delete") || choice.equals("d")) {
				;
			}
			else if (choice.equals("quit") || choice.equals("q")) {
				t=false;
				break;
			}
			else {
			System.out.println("Invalid input");
			}
		
		}
	}
	
}	
