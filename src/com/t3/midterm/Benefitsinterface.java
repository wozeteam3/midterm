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
	
		public void createBenefit(int benefitId, int dental, int life, int health, double kAmount) {
			String query= "INSERT INTO benefits (benefit_id, dental, life, health, 401k_match_amount )values( " + benefitId +" "+ dental +" "+ life +" "+ health +" "+ kAmount +")";
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
			String query= "SELECT * from benefits WHERE benefit_id="+ benefitId;
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
		
		public void readDentalBenefit(int dental) {
			String query= "SELECT * from benefits WHERE dental="+dental;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, dental);
				
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
		
		public void readLifeBenefit(int life) {
			String query= "SELECT * from benefits WHERE life= "+life;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, life);
				
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
		
		public void readHealthBenefit(int health) {
			String query= "SELECT * from benefits WHERE health= "+health;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, health);
				
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
		public void read401k(int kAmount) {
			String query= "SELECT * from benefits WHERE 401k_match_amount= "+kAmount;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, kAmount);
				
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
		public void updateAllBenefit(int benefitId, int dental, int life, int health, int kAmount ) {
			String query= "UPDATE benefits set  dental= "+ dental +" life="+ life +" health= "+ health +" 401k_match_amount"+ kAmount + "Where benefit_id= "+ benefitId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				ps.setInt(2, dental);
				ps.setInt(3, life);
				ps.setInt(4,health);
				ps.setInt(5, kAmount);
				
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void updateOneBenefit(String benefitName, int benefitIdPlan, int benefitId) {
			String query= "UPDATE benefits set "+ benefitName.toLowerCase() + "= "+ benefitIdPlan +"WHERE benfit_id= "+ benefitId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setString(1, benefitName);
				ps.setInt(2, benefitIdPlan);
				ps.setInt(3, benefitId);
				
				ps.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteBenefit(int benefitId) {
			String query= "DELETE FROM benefits WHERE benefit_id="+ benefitId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	}
