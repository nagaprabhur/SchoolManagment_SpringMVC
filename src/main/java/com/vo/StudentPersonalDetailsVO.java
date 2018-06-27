package com.vo;

public class StudentPersonalDetailsVO extends ClassVO{
	
	private int studentID;
	private String studentName;
	private int studentAge;
	private int year;
	private String exceptionMesg;
	
	private String address;
	
	public void setYear(int year) {
		this.year = year;
	}public int getYear() {
		return year;
	}
	
	public int getStudentAge() {
		return studentAge;
	}
	 public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExceptionMesg() {
		return exceptionMesg;
	}
	public void setExceptionMesg(String exceptionMesg) {
		this.exceptionMesg = exceptionMesg;
	}
	
	
	

}
