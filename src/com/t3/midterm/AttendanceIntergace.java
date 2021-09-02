package com.t3.midterm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class AttendanceIntergace {

	public class  AttendanceInterface {
		static DataSource db;
		
		final String CREATE    = "INSERT INTO attendance (EMP_ID, TARDY, ABSENTS, EXCUSED_TARDY, EXCUSED_ABSENTS) VALUES (?,?,?,?,?,?)";
		final String READ_ID   = "SELECT * FROM attendance WHERE emp_id = ?";
		final String READ_TARDY = "SELECT * FROM attendance WHERE tardys = ?";
		final String READ_ABSENTS = "SELECT * FROM attendance WHERE absents = ?";
		final String READ_EXCUSEDA ="SELECT * FROM attendance WHERE excused_absents = ?";
		final String READ_EXCUSEDT = "SELECT * FROM attendance WHERE excused_tardys = ?";
		final String READ_ALL  = "SELECT * FROM attendance";
		final String UPDATE    = "UPDATE attendance  SET  absent= ?, tardy = ?, excused_tardy = ?, excused_absents = ? WHERE emp_id = ?";
		final String DELETE    = "DELETE FROM attendance WHERE emp_id = ?";
		

	
	
	public void AttendancInterface(DataSource db) {
		AttendanceInterface.db = db;
	}
	
	
		public void deleteAttendance(int Id) {
			final String DELETE    = "DELETE FROM attendance WHERE emp_id = ?";
			try (Connection c = db.getConnection();
					PreparedStatement ps = c.prepareStatement(DELETE);) {
				ps.setInt(1, Id);
			
				ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	public List<Attendance> readAllAttendance() {
		String query= "SELECT * from attendance ";
		List<Attendance> attList = new ArrayList<Attendance>();
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				attList.add(new Attendance(rs.getInt(1), 
										   rs.getInt(2), 
										   rs.getInt(3),
										   rs.getInt(4),
										   rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return attList;
	}
	
	public void updateAllAttendance( int present, int tardy, int absents, int eTardys, int eAbsent, int id) {
		final String UPDATE    = "UPDATE attendance  SET  absents = ?, tardy = ?, excused_tardys = ?, excused_absents = ? WHERE emp_id = ?";
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(UPDATE);) {
			ps.setInt(1, id);
			ps.setInt(2, present);
			ps.setInt(3, tardy);
			ps.setInt(4,absents);
			ps.setInt(5, eTardys);
			ps.setInt(6, eAbsent);
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void createBenefit(int id, int tardys , int absents, int eTardy , int eAbsent ) {
		final String CREATE    = "INSERT INTO attendance (EMP_ID, TARDY, ABSENTS, EXCUSED_TARDY, EXCUSED_ABSENTS) VALUES (?,?,?,?,?,?)";
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(CREATE);) {
			ps.setInt(1, id);
			ps.setInt(2, tardys);
			ps.setInt(3, absents);
			ps.setInt(4, eTardy);
			ps.setDouble(5, eAbsent);
			
			ps.executeUpdate();
	    }
		catch(SQLException e) {
			e.printStackTrace();
		}
}
	public void readAllTableByEmpId(int empId) {
		final String READ_ID   = "SELECT * FROM attendance WHERE emp_id = ?";
		Attendance returnedAttendance = null;
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_ID);) {
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedAttendance = new Attendance(rs.getInt(1), 
							 						rs.getInt(2), 
							 						rs.getInt(3),
													rs.getInt(4),
													rs.getInt(5));
			}
		}	
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	public Attendance readTardy(int tardys) {
		final String READ_TARDY = "SELECT * FROM attendance WHERE tardys = ?";
		Attendance returnedAttendance = null;
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_TARDY);) {
			ps.setInt(1, tardys);
			
			
			ResultSet rs = ps.executeQuery(READ_TARDY);

			while (rs.next()) {
				returnedAttendance = new Attendance (rs.getInt(1), 
													 rs.getInt(2), 
													 rs.getInt(3),
													 rs.getInt(4),
													 rs.getInt(5));
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedAttendance;
	}	
		
	
	public Attendance readAbsents(int absents) {
		final String READ_ABSENTS = "SELECT * FROM attendance WHERE absents = ?";
		Attendance returnedAttendance = null;
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_ABSENTS);) {
			ps.setInt(1, absents);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedAttendance = new Attendance(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedAttendance;
	}	
	
	
	public Attendance readExcusedTardy(int excusedT) {
		final String READ_EXCUSEDT = "SELECT * FROM attendance WHERE excused_tardys = ?";
		Attendance returnedAttendance = null;
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_EXCUSEDT);) {
			ps.setInt(1, excusedT);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedAttendance = new Attendance(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedAttendance;
	}	
	
	
	public Attendance readExcusedAbsents(int excusedA) {
		final String READ_EXCUSEDA ="SELECT * FROM attendance WHERE excused_absents = ?";
		Attendance returnedAttendance = null;
		try (Connection c = db.getConnection();
				PreparedStatement ps = c.prepareStatement(READ_EXCUSEDA);) {
			ps.setInt(1, excusedA);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				returnedAttendance = new Attendance(rs.getInt(1), 
	  												rs.getInt(2), 
	  												rs.getInt(3),
	  												rs.getInt(4),
	  												rs.getInt(5));
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return returnedAttendance;
	}	
}
}