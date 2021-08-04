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
			String query= "INSERT INTO benefits (BENEFIT,BENFITID)values( '" + benefitName +"' "+ benefitId +")";
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Project m = new Project();
					m.setId(rs.getLong("id"));
					m.setName(rs.getString("name"));
					array.add(m);
		}
	}
		
		public void readAllBenefits() {
			String query= "SELECT * from benefits ";
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Project m = new Project();
					m.setId(rs.getLong("id"));
					m.setName(rs.getString("name"));
					array.add(m);
		}
		
		public void readBenefitId(int benefitId) {
			String query= "SELECT * from benefits WHERE id="+ benefitId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Project m = new Project();
					m.setId(rs.getLong("id"));
					m.setName(rs.getString("name"));
					array.add(m);
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void readBenefitName(String benefitName) {
			String query= "SELECT * from benefits WHERE benefitName="+benefitName;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Project m = new Project();
					m.setId(rs.getLong("id"));
					m.setName(rs.getString("name"));
					array.add(m);
				
				ps.executeUpdate();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		public void updateBenefit(int empId, String benefitName, int benefitId) {
			String query= "UPDATE benefits set benefitId="+ benefitId + "Where benefitName="+ benefitName +"and EMP_ID="+ empId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					Project m = new Project();
					m.setId(rs.getLong("id"));
					m.setName(rs.getString("name"));
					array.add(m);
				
				ps.executeUpdate();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteBenefit(int empId) {
			String query= "DELETE FROM benefits WHERE EMP_ID="+ empId;
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(query);) {
				ResultSet rs = statement.executeQuery();
				while (rs.next()) {
					
					ps.setInt(rs.getLong("id"));
					ps.setString(rs.getString("name"));
				
					ps.executeUpdate();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
