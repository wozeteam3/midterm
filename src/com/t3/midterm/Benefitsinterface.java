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
		
		final String CREATE    = "INSERT INTO benefits (benefit_id, dental, life, health, 401k_match_amount) VALUES (?,?,?,?,?)";
		final String READ_ID   = "SELECT * FROM benefits WHERE benefit_id = ?";
		final String READ_DENTAL = "SELECT * FROM benefits WHERE dental = ?";
		final String READ_LIFE = "SELECT * FROM benefits WHERE life = ?";
		final String READ_HEALTH="SELECT * FROM benefits WHERE health = ?";
		final String READ_KAMOUNT = "SELECT * FROM benefits WHERE 401k_match_amount = ?";
		final String READ_ALL  = "SELECT * FROM benefits";
		final String UPDATE    = "UPDATE benefits  SET dental = ?, life = ?, health = ?, 401k_match_amount = ? WHERE benefit_id = ?";
		final String DELETE    = "DELETE FROM benefits WHERE benefit_id = ?";
		
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
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(CREATE);) {
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
		public void readAllTableByBenefitId(int benefitId) {
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(READ_ID);) {
				ps.setInt(1, benefitId);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
							 						rs.getInt(2), 
							 						rs.getInt(3),
													rs.getInt(4),
													rs.getInt(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		/**
		 * A join that allows the user to see the benefits and the employee tables. 
		 * @param benefitId
		 */
		public Benefits readDental(int dental) {
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(READ_LIFE);) {
				ps.setInt(1, dental);
				
				
				ResultSet rs = ps.executeQuery(READ_DENTAL);

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));			
				}
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return returnedBenefits;
		}	
			
		
		public Benefits readHealth(int health) {
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(READ_LIFE);) {
				ps.setInt(1, health);
				
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));			
				}
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return returnedBenefits;
		}	
		
		
		public Benefits readkAmount(int kAmount) {
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(READ_KAMOUNT);) {
				ps.setInt(1, kAmount);
				
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));			
				}
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return returnedBenefits;
		}	
		
		/**
		 * Allows the user to see everything in the benefits table
		 * @return 
		 */
		public List<Benefits> readAllBenefits() {
			String query= "SELECT * from benefits ";
			List<Benefits> benList = new ArrayList<Benefits>();
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					benList.add(new Benefits(rs.getInt(1), 
											  rs.getInt(2), 
											  rs.getInt(3),
											  rs.getInt(4),
											  rs.getInt(5)));
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
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setInt(1, benefitId);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
							  						rs.getInt(2), 
							  						rs.getInt(3),
							  						rs.getInt(4),
							  						rs.getInt(5));		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		/**
		 * This allows the user to see benefit id and other plans that has a chosen plan id inside a chosen benefit 
		 * @param benefitName & planId
		 * @return 
		 */
		public Benefits readLife(int life) {
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(READ_LIFE);) {
				ps.setInt(1, life);
				
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));			
				}
				
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return returnedBenefits;
		}	
		
		
		/**
		 * This allows the user to see benefit id and plans that has a certain 401k plan 
		 * @param kAmount
		 * @return 
		 */
		public Benefits read401k(int kAmount) {
			String query= "SELECT * from benefits WHERE 401k_match_amount= "+kAmount;
			Benefits returnedBenefits = null;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ps.setDouble(1, kAmount);
				
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					returnedBenefits = new Benefits(rs.getInt(1), 
													rs.getInt(2), 
													rs.getInt(3),
													rs.getInt(4),
													rs.getInt(5));			
				}
				return returnedBenefits;
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return returnedBenefits;
		}	
		/**
		 * Allows the user to update all the benefits that has a certain benefitId
		 * @param benefitId
		 * @param dental
		 * @param life
		 * @param health
		 * @param kAmount
		 */
		public void updateAllBenefit(int benefitId, int dental, int life, int health, int kAmount ) {
			
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(UPDATE);) {
				ps.setInt(1, dental);
				ps.setInt(2, life);
				ps.setInt(3, health);
				ps.setInt(4,kAmount);
				ps.setInt(5, benefitId);
				
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
		public void updateOneBenefit(int benefit_id, int dental, int life, int health, int kAmount) {
			
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(UPDATE);) {
				ps.setInt(1, dental);
				ps.setInt(2, life);
				ps.setInt(3, health);
				ps.setInt(3, kAmount);
				ps.setInt(3, benefit_id);
				
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
