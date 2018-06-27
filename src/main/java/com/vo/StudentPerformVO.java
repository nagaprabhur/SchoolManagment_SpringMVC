package com.vo;

public class StudentPerformVO extends ExceptionVO{
	
	private int studentID;
	private String studentName;
	private int year;
	private float performance;
	private String grade;
	
	public String getGrade() {
		return grade;
	}public void setGrade(String grade) {
		this.grade = grade;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getPerformance() {
		return performance;
	}
	public void setPerformance(float performance) {
		this.performance = performance;
	}
	
	

}
