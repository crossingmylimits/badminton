package dao;

import java.sql.*;

import model.CustomerBean;
import model.StaffBean;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;


public class StaffDAO {
	  static Connection con = null;
	  static PreparedStatement ps = null;
	  static Statement stmt = null;
	  static ResultSet rs = null;
	  private int StaffID,ManagerID,StaffPhoneNum;
	  private String StaffName,StaffRole,StaffEmail,StaffPass;
	  
	//add staff
	  public void addStaff(StaffBean bean) {
	    
	    ManagerID  = bean.getManagerID();
	    StaffPhoneNum = bean.getStaffPhoneNum();
	    StaffName = bean.getStaffName();
	    StaffRole = bean.getStaffRole();
	    StaffEmail = bean.getStaffEmail();
	    StaffPass = bean.getStaffPass();
	    
	    try {      
	      //call getConnection() method
	    	con = db.ConnectionManager.getConnection();
	      
	      //3. create statement
	      ps = con.prepareStatement("INSERT INTO staff(Staff_Name,Staff_PhoneNum,Staff_Role,Staff_Email,Staff_Pass,Manager_ID)VALUES(?,?,?,?,?,?)");
	      
	      ps.setString(1, StaffName);
	      ps.setInt(2, StaffPhoneNum);
	      ps.setString(3, StaffRole);
	      ps.setString(4, StaffEmail);
	      ps.setString(5, StaffPass);
	      ps.setInt(6, ManagerID);
	      
	      //4. execute query
	      ps.executeUpdate();
	      System.out.println("Successfully inserted");
	      
	      //5. close connection
	      con.close();
	      
	    }catch(Exception e) {
	      e.printStackTrace();
	      
	    }
	  }  
	    public static List<StaffBean> getAllStaff() {
	        List<StaffBean> staffs = new ArrayList<StaffBean>();

	        try {
	            // Get connection
	            con = db.ConnectionManager.getConnection();

	            // Create statement
	            stmt = con.createStatement();
	            String sql = "SELECT * FROM staff ORDER BY Staff_ID";

	            // Execute query
	            rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                StaffBean s = new StaffBean();
	                s.setStaffID(rs.getInt("Staff_ID"));
	                s.setStaffName(rs.getString("Staff_Name"));
	                s.setStaffPhoneNum(rs.getInt("Staff_PhoneNum"));
	                s.setStaffRole(rs.getString("Staff_Role"));
	                s.setStaffEmail(rs.getString("Staff_Email"));
	                s.setStaffPass(rs.getString("Staff_Pass"));
	                s.setManagerID(rs.getInt("Manager_ID"));
	                staffs.add(s);
	            }

	            // Close connection
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return staffs;
	    }

	    public static StaffBean getStaffByID(int StaffID) {
	        StaffBean staff = new StaffBean();

	        try {
	            // Get connection
	            con = db.ConnectionManager.getConnection();

	            // Create statement
	            ps = con.prepareStatement("SELECT * FROM staff WHERE Staff_ID = ?");
	            ps.setInt(1, StaffID);

	            // Execute query
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                
	                staff.setStaffID(rs.getInt("Staff_ID"));
	                staff.setStaffName(rs.getString("Staff_Name"));
	                staff.setStaffPhoneNum(rs.getInt("Staff_PhoneNum"));
	                staff.setStaffRole(rs.getString("Staff_Role"));
	                staff.setStaffEmail(rs.getString("Staff_Email"));
	                staff.setStaffPass(rs.getString("Staff_Pass"));
	                staff.setManagerID(rs.getInt("Manager_ID"));
	            }

	            // Close connection
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return staff;
	    }

	    public void updateStaff(StaffBean staff) {
	        StaffID = staff.getStaffID();
	        StaffName = staff.getStaffName();
	        StaffPhoneNum = staff.getStaffPhoneNum();
	        StaffRole = staff.getStaffRole();
	        StaffEmail = staff.getStaffEmail();
	        StaffPass = staff.getStaffPass();
	        ManagerID = staff.getManagerID();

	        try {
	            // Get connection
	            con = db.ConnectionManager.getConnection();

	            // Create statement
	            ps = con.prepareStatement(
	                    "UPDATE staff SET Staff_Name=?, Staff_PhoneNum=?, Staff_Role=?, Staff_Email=?, Staff_Pass=?, Manager_ID=? WHERE Staff_ID=?");
	            ps.setString(1, StaffName);
	            ps.setInt(2, StaffPhoneNum);
	            ps.setString(3, StaffRole);
	            ps.setString(4, StaffEmail);
	            ps.setString(5, StaffPass);
	            ps.setInt(6, ManagerID);
	            ps.setInt(7, StaffID);

	            // Execute query
	            ps.executeUpdate();
	            System.out.println("Successfully updated");

	            // Close connection
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStaff(int staffID) {
	        try {
	            // Get connection
	            con = db.ConnectionManager.getConnection();

	            // Create statement
	            ps = con.prepareStatement("DELETE FROM staff WHERE Staff_ID=?");
	            ps.setInt(1, staffID);

	            // Execute query
	            ps.executeUpdate();

	            // Close connection
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public StaffBean authenticateStaff(String StaffName, String StaffPass) {
	        StaffBean staff = new StaffBean();

	        try {
	            // Get connection
	            con = ConnectionManager.getConnection();

	            // Create statement
	            ps = con.prepareStatement("SELECT * FROM staff WHERE Staff_Name = ? AND Staff_Pass = ?");
	            ps.setString(1, StaffName);
	            ps.setString(2, StaffPass);

	            // Execute query
	            rs = ps.executeQuery();
	            
	            // Check if a customer is found
	            if (rs.next()) {
	                // Create a new CustomerBean object
	                staff.setStaffID(rs.getInt("Staff_ID"));
	                staff.setStaffName(rs.getString("Staff_Name"));
	                staff.setStaffPhoneNum(rs.getInt("Staff_PhoneNum"));
	                staff.setStaffRole(rs.getString("Staff_Role"));
	                staff.setStaffEmail(rs.getString("Staff_Email"));
	                staff.setStaffPass(rs.getString("Staff_Pass"));
	                staff.setManagerID(rs.getInt("Manager_ID"));
	            }

	            // Close connection
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return staff;
	    }

	}

