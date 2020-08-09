package com.shashank.loop;


public class Student {
	
	private String studentID;
	private String firstName;
	private String lastName;
	
	public String getStudentID() {
		return studentID;
	}
	public String setStudentID(String studentID) {
		return this.studentID = studentID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		return this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}
	public Student() {
		studentID = null;
		firstName = null;
		lastName = null;
	}
	public Student(String studentID, String firstName, String lastName) {
		super();
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
