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
	/**
	 * Adds a new line of data with a new benefit Id with its new benefit plans
	 * @param benefitId
	 * @param dental
	 * @param life
	 * @param health
	 * @param kAmount
	 * 
	 */
		public void createBenefit(int benefitId, int dental, int life, int health, double kAmount) {
			String query= "INSERT INTO benefits (benefit_id, dental, life, health, 401k_match_amount )values( " + benefitId +" "+ dental +" "+ life +" "+ health +" "+ kAmount +")";
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				ps.setInt(2, dental);
				ps.setInt(3, life);
				ps.setInt(4, health);
				ps.setDouble(5, kAmount);
				
				ps.executeUpdate();
		    }
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
		
		
		
		/**
		 * Allows the user to see everything in the benefits table
		 */
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
		/**
		 * This allows the user to see what benefit plans does a certain benefit Id have
		 * @param benefitId
		 */
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
		
		/**
		 * This allows the user to see benefit id and other plans that has a chosen plan id inside a chosen benefit 
		 * @param benefitName & planId
		 */
		public void readDentalBenefit(String benefitName, int planId) {
			String query= "SELECT * from benefits WHERE "+ benefitName.toLowerCase() +"="+planId;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setString(1, benefitName);
				ps.setInt(2, planId);
				
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
		
		
		/**
		 * This allows the user to see benefit id and plans that has a certain 401k plan 
		 * @param kAmount
		 */
		public void read401k(double kAmount) {
			String query= "SELECT * from benefits WHERE 401k_match_amount= "+kAmount;
			benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setDouble(1, kAmount);
				
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
		/**
		 * Allows the user to update all the benefits that has a certain benefitId
		 * @param benefitId
		 * @param dental
		 * @param life
		 * @param health
		 * @param kAmount
		 */
		public void updateAllBenefit(int benefitId, int dental, int life, int health, double kAmount ) {
			String query= "UPDATE benefits set  dental= "+ dental +" life="+ life +" health= "+ health +" 401k_match_amount"+ kAmount + "Where benefit_id= "+ benefitId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				ps.setInt(2, dental);
				ps.setInt(3, life);
				ps.setInt(4,health);
				ps.setDouble(5, kAmount);
				
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Allows the user to update a single benefit that has a certain benefit Id
		 * @param benefitName
		 * @param benefitIdPlan
		 * @param benefitId
		 */
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
		
		/**
		 * Allows the user to delete a row of data that has a certain benefit Id
		 * @param benefitId
		 */
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
