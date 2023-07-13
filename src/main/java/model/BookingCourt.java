package model;

import java.util.Date;
import java.sql.Time;
public class BookingCourt {
	private int BookingID;
	 private Date BookingDate;
	 private String BookingTime;
	 private int CustID;
	 private int CourtID;
	public int getBookingID() {
		return BookingID;
	}
	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	public String getBookingTime() {
		return BookingTime;
	}
	public void setBookingTime(String bookingTime) {
		BookingTime = bookingTime;
	}
	public int getCustID() {
		return CustID;
	}
	public void setCustID(int custID) {
		CustID = custID;
	}
	public int getCourtID() {
		return CourtID;
	}
	public void setCourtID(int courtID) {
		CourtID = courtID;
	}
	 
}

