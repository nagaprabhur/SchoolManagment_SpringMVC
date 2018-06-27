package com.vo;

public class ClassPerformVO extends ExceptionVO{
	
	private int totalNoOfStudents;
	private String className;
	private float classPercentage;
	private String classGrade;
	public int getTotalNoOfStudents() {
		return totalNoOfStudents;
	}
	public void setTotalNoOfStudents(int totalNoOfStudents) {
		this.totalNoOfStudents = totalNoOfStudents;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public float getClassPercentage() {
		return classPercentage;
	}
	public void setClassPercentage(float classPercentage) {
		this.classPercentage = classPercentage;
	}
	public String getClassGrade() {
		return classGrade;
	}
	public void setClassGrade(String classGrade) {
		this.classGrade = classGrade;
	}
	
	

}
