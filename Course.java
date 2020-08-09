package com.shashank.loop;

public class Course {
	private String courseID;
	private String courseTitle;
	private String teacherID;
	
	public String getCourseID() {
		return courseID;
	}
	public String setCourseID(String courseID) {
		return this.courseID = courseID;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public String setCourseTitle(String courseTitle) {
		return this.courseTitle = courseTitle;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public String setTeacherID(String teacherID) {
		return this.teacherID = teacherID;
	}
	public Course() {
		courseID = null;
		courseTitle = null;
		teacherID = null;
	}
	public Course(String courseID, String courseTitle, String teacherID ) {
		this.courseID = courseID;
		this.courseTitle = courseTitle;
		this.teacherID = teacherID;
	}
}
