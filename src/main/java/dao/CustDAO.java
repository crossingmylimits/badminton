package dao;
import java.sql.*;
import java.util.*;
import model.CustomerBean;
import db.ConnectionManager;


public class CustDAO {
    static Connection con = null;
    static PreparedStatement ps = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    private int CustID;
    private String CustName;
    private int CustPhoneNum;
    private String CustEmail;
    private String CustPass;

    public void addCustomer(CustomerBean bean) {
        
        CustName = bean.getCustName();
        CustPhoneNum = bean.getCustPhoneNum();
        CustEmail = bean.getCustEmail();
        CustPass = bean.getCustPass();

        try {
            // Get connection
            con = ConnectionManager.getConnection();

            // Create statement
            ps = con.prepareStatement(
                    "INSERT INTO customer(Cust_Name,Cust_PhoneNum,Cust_Email,Cust_Pass)VALUES(?,?,?,?)");
            
            ps.setString(1, CustName);
            ps.setInt(2, CustPhoneNum);
            ps.setString(3, CustEmail);
            ps.setString(4, CustPass);

            // Execute query
            ps.executeUpdate();
            System.out.println("Successfully inserted");

            // Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


public static List<CustomerBean> getAllCustomers() {
    List<CustomerBean> customers = new ArrayList<CustomerBean>();

    try {
        // Get connection
        con = ConnectionManager.getConnection();

        // Create statement
        stmt = con.createStatement();
        String sql = "SELECT * FROM customer ORDER BY Cust_ID";

        // Execute query
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            CustomerBean c = new CustomerBean();
            c.setCustID(rs.getInt("Cust_ID"));
            c.setCustName(rs.getString("Cust_Name"));
            c.setCustPhoneNum(rs.getInt("Cust_PhoneNum"));
            c.setCustEmail(rs.getString("Cust_Email"));
            c.setCustPass(rs.getString("Cust_Pass"));
            customers.add(c);
        }

        // Close connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return customers;
}

public static CustomerBean getCustomerByID(int CustID) {
    CustomerBean customer = new CustomerBean();
    try {
        // Get connection
        con = ConnectionManager.getConnection();

        // Create statement
        ps = con.prepareStatement("SELECT * FROM customer WHERE Cust_ID= ?");
        ps.setInt(1, CustID);

        // Execute query
        rs = ps.executeQuery();
        if (rs.next()) {
            customer.setCustID(rs.getInt("Cust_ID"));
            customer.setCustName(rs.getString("Cust_Name"));
            customer.setCustPhoneNum(rs.getInt("Cust_PhoneNum"));
            customer.setCustEmail(rs.getString("Cust_Email"));
            customer.setCustPass(rs.getString("Cust_Pass"));
        }

        // Close connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return customer;
}



public void updateCustomer(CustomerBean customer) {
    CustID = customer.getCustID();
    CustName = customer.getCustName();
    CustPhoneNum = customer.getCustPhoneNum();
    CustEmail = customer.getCustEmail();
    CustPass = customer.getCustPass();

    try {
        // Get connection
        con = ConnectionManager.getConnection();

        // Create statement
        ps = con.prepareStatement(
                "UPDATE customer SET Cust_Name=?, Cust_PhoneNum=?, Cust_Email=?, Cust_Pass=? WHERE Cust_ID=?");
        ps.setString(1, CustName);
        ps.setInt(2, CustPhoneNum);
        ps.setString(3, CustEmail);
        ps.setString(4, CustPass);
        ps.setInt(5, CustID);

        // Execute query
        ps.executeUpdate();
        System.out.println("Successfully updated");

        // Close connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void deleteCustomer(int custID) {
    try {
        // Get connection
        con = ConnectionManager.getConnection();

        // Create statement
        ps = con.prepareStatement("DELETE FROM customer WHERE Cust_ID=?");
        ps.setInt(1, custID);

        // Execute query
        ps.executeUpdate();

        // Close connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


public CustomerBean authenticateCustomer(String CustName, String CustPass) {
    CustomerBean customer = new CustomerBean();

    try {
        // Get connection
        con = ConnectionManager.getConnection();

        // Create statement
        ps = con.prepareStatement("SELECT * FROM customer WHERE Cust_Name = ? AND Cust_Pass = ?");
        ps.setString(1, CustName);
        ps.setString(2, CustPass);

        // Execute query
        rs = ps.executeQuery();
        
        // Check if a customer is found
        if (rs.next()) {
            // Create a new CustomerBean object
            customer = new CustomerBean();
            customer.setCustID(rs.getInt("Cust_ID"));
            customer.setCustName(rs.getString("Cust_Name"));
            customer.setCustPhoneNum(rs.getInt("Cust_PhoneNum"));
            customer.setCustEmail(rs.getString("Cust_Email"));
            customer.setCustPass(rs.getString("Cust_Pass"));
        }

        // Close connection
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return customer;
}




}
