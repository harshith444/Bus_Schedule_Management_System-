package com.wipro.bus.bean;

public class ScheduleBean {
	String ScheduleId;
	String source;
	String destination;
	String startTime;
	String arrivalTime;
	public String getScheduleId() {
		return ScheduleId;
	}
	public void setScheduleId(String scheduleId) {
		ScheduleId = scheduleId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
}
