package model;
import java.util.Date;

public class PaymentBean {
	 private int PaymentID;
	 private double PaymentTotal;
	 private Date PaymentDate;
	 private String PaymentTime;
	 private int BookingID;
	 private int CustID;
	 public int getPaymentID() {
	  return PaymentID;
	 }
	 public void setPaymentID(int paymentID) {
	  PaymentID = paymentID;
	 }
	 public double getPaymentTotal() {
	  return PaymentTotal;
	 }
	 public void setPaymentTotal(double paymentTotal) {
	  PaymentTotal = paymentTotal;
	 }
	 public Date getPaymentDate() {
	  return PaymentDate;
	 }
	 public void setPaymentDate(Date paymentDate) {
	  PaymentDate = paymentDate;
	 }
	 public String getPaymentTime() {
	  return PaymentTime;
	 }
	 public void setPaymentTime(String paymentTime) {
	  PaymentTime = paymentTime;
	 }
	 public int getBookingID() {
	  return BookingID;
	 }
	 public void setBookingID(int bookingID) {
	  BookingID = bookingID;
	 }
	 public int getCustID() {
	  return CustID;
	 }
	 public void setCustID(int custID) {
	  CustID = custID;
	 }
	 
	
}
