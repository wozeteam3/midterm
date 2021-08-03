package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class Benefitsinterface {
	
	public class BenefitInterface {
		static DataSource db;
		
	public void BenefitsInterface(DataSource db) {
			BenefitsInterface.db = db;
		}
	
		public void createBenefit(String benefitName, int benefitId) {
			try (Connection c = db.getConnection()){
				String query= "INSERT INTO benefits (BENEFIT,BENFITID)values( '" + benefitName +"' "+ benefitId +")";
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
		public void readAllBenefits() {
			try (Connection c = db.getConnection()){
				String query= "SELECT * from benefits ";
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void readBenefitId(int benefitId) {
			try (Connection c = db.getConnection();){
				String query= "SELECT * from benefits WHERE benefitId="+benefitId;
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void readBenefitName(String benefitName) {
			try (Connection c = db.getConnection();){
				String query= "SELECT * from benefits WHERE benefitName="+benefitName;
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void updateBenefit(int empId, String benefitName, int benefitId) {
			try (Connection c = db.getConnection();){
				String query= "UPDATE benefits set benefitId="+ benefitId + "Where benefitName="+ benefitName +"and EMP_ID="+ empId;
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteBenefit(int empId) {
			try (Connection c = db.getConnection();){
				String query= "DELETE FROM benefits WHERE EMP_ID="+ empId;
				Statement statement;
				statement = c.createStatement();
    			statement.execute(query);		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
