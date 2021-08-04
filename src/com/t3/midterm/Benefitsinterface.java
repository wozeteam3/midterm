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
			BenefitInterface.db = db;
	}
	
		public void createBenefit(String benefitName, int benefitId) {
			String query= "INSERT INTO benefits (BENEFIT,BENFITID)values( '" + benefitName +"' "+ benefitId +")";
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setString(1, benefitName);
				ps.setInt(2, benefitId);
				
				ps.executeUpdate();
		    }
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
		public void readAllBenefits() {
			String query= "SELECT * from benefits ";
			List<Benefits> benList = new ArrayList<Benefits>();
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					benList.add(new Employee(rs.getInt(1), 
											 rs.getString(2), 
											 rs.getString(3)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return benList;
		}
		
		public void readBenefitId(int benefitId) {
			String query= "SELECT * from benefits WHERE id="+ benefitId;
			Employee returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
							 						rs.getString(2), 
							 						rs.getString(3));		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public void readBenefitName(String benefitName) {
			String query= "SELECT * from benefits WHERE benefitName="+benefitName;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setString(1, benefitName);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Employee(rs.getInt(1), 
	 												rs.getString(2), 
	 												rs.getString(3));		
				}
				return returnedBenefits;
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		public void updateBenefit( String benefitName, int benefitId, int empId) {
			String query= "UPDATE benefits set benefitId="+ benefitId + "Where benefitName="+ benefitName +"and EMP_ID="+ empId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setString(1, benefitName);
				ps.setInt(2, benefitId);
				ps.setInt(3, empId);
				
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteBenefit(int empId) {
			String query= "DELETE FROM benefits WHERE EMP_ID="+ empId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, empId);
				
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
