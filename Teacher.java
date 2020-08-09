package com.shashank.loop;

public class Teacher {
	private String teacherID;
	private String teacherName;
	
	public String getTeacherID() {
		return teacherID;
	}
	public String setTeacherID(String teacherID) {
		return this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public String setTeacherName(String teacherName) {
		return this.teacherName = teacherName;
	}
	public Teacher() {
		teacherID = null;
		teacherName = null;
	}
	public Teacher(String teacherID, String teacherName) {
		this.teacherID = teacherID;
		this.teacherName = teacherName;
	}

}
