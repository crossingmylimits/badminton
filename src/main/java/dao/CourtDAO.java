package dao;

import java.sql.*;
import java.util.*;

import db.ConnectionManager;
import model.CourtBean;

public class CourtDAO {
	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	private int CourtID;
	private String CourtName;

    public void addCourt(CourtBean court) {
    	CourtName = court.getCourtName();
    	
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("INSERT INTO court (Court_Name) VALUES (?)");
            ps.setString(1,CourtName );

            ps.executeUpdate();
            System.out.println("Successfully inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    public static List<CourtBean> getAllCourts() {
        List<CourtBean> courts = new ArrayList<CourtBean>();
        try {
            con = ConnectionManager.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM court ORDER BY Court_Id";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CourtBean court = new CourtBean();
                court.setCourtID(rs.getInt("Court_ID"));
                court.setCourtName(rs.getString("Court_Name"));

                courts.add(court);
            }
            
            con.close();
            
        }catch(Exception e) {
          e.printStackTrace();
        
          
        }
        
        return courts;
      }
        
    public void deleteCourt(int courtID) {
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("DELETE FROM court WHERE Court_ID = ?");
            ps.setInt(1, courtID);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

    public void updateCourt(CourtBean court) {
    	CourtID = court.getCourtID();
    	CourtName = court.getCourtName();
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("UPDATE court SET Court_Name = ? WHERE Court_ID = ?");
            ps.setString(1, CourtName);
            ps.setInt(2, CourtID);

            ps.executeUpdate();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

    public static CourtBean getCourtByID(int CourtID) {
        CourtBean court = new CourtBean();
        try {
            con = ConnectionManager.getConnection();
            ps = con.prepareStatement("SELECT * FROM court WHERE Court_ID = ?");
            ps.setInt(1, CourtID);
            rs = ps.executeQuery();

            if (rs.next()) {        
                court.setCourtID(rs.getInt("Court_ID"));
                court.setCourtName(rs.getString("Court_Name"));
            }
            con.close();
            
        }catch(Exception e) {
          e.printStackTrace();  
        }      
        return court;
      }

}
