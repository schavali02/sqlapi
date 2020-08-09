package com.shashank.loop;

public class StudentCourse {
	private String studentID;
	private String courseID;
	private String grade;
	
	public String getStudentID() {
		return studentID;
	}
	public String setStudentID(String studentID) {
		return this.studentID = studentID;
	}
	public String getCourseID() {
		return courseID;
	}
	public String setCourseID(String courseID) {
		return this.courseID = courseID;
	}
	public String getGrade() {
		return grade;
	}
	public String setGrade(String grade) {
		return this.grade = grade;
	}
	public StudentCourse() {
		studentID = null;
		courseID = null;
		grade = null;
	}
	public StudentCourse(String studentID, String courseID) {
		this.studentID = studentID;
		this.courseID = courseID;
		
	}
	public StudentCourse(String grade) {
		this.grade = grade;
	}
	public StudentCourse(String studentID, String courseID, String grade) {
		this.studentID = studentID;
		this.courseID = courseID;
		this.grade = grade;
	}

}
