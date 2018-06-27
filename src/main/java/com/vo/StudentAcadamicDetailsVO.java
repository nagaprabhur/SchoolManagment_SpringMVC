package com.vo;

public class StudentAcadamicDetailsVO extends SubjectVO{
	
	private int studentID;
	private String studentName;
	private int year;
	private Long totalMarks;
	private String grade;
	private String marksType;
	private float percentage;
	private String exceptionMesg;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMarksType() {
		return marksType;
	}
	public void setMarksType(String marksType) {
		this.marksType = marksType;
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
	public Long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public float getPercentage() {
		return percentage;
	}public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

		public void setExceptionMesg(String exceptionMesg) {
			this.exceptionMesg = exceptionMesg;
		}public String getExceptionMesg() {
			return exceptionMesg;
		}
}
