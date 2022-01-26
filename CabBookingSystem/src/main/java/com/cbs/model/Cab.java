package com.cbs.model;

import java.time.LocalTime;
import java.util.Objects;

public class Cab {
	private  Integer cabNo;
	private LocalTime startTime;
	private LocalTime endTime;
	private Integer bookingStatus;//0 means available, 1 means Booked
	
	
	
	public Cab(Integer cabNo) {
		super();
		this.cabNo = cabNo;
		this.bookingStatus = 0;
	}
	public Cab(Integer cabNo, Integer bookingStatus) {
		super();
		this.cabNo = cabNo;
		this.bookingStatus = bookingStatus;
	}
	public Integer getCabNo() {
		return cabNo;
	}
	public void setCabNo(Integer cabNo) {
		this.cabNo = cabNo;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public Integer getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(Integer bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookingStatus, cabNo, endTime, startTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cab other = (Cab) obj;
		return Objects.equals(bookingStatus, other.bookingStatus) && Objects.equals(cabNo, other.cabNo)
				&& Objects.equals(endTime, other.endTime) && Objects.equals(startTime, other.startTime);
	}
	
	
	
	

}
