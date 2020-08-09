package com.shashank.loop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.model.ModelValidationException;

@Path("/courses")
public class CourseAPI {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getCourses() {
	  try {
		  StringBuilder sb = new StringBuilder();
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
		  Statement stmt = connection.createStatement();
		  ResultSet rs = stmt.executeQuery("SELECT * from courses");
		  while(rs.next()) {
			  sb.append("Course ID: " + rs.getInt("courseID") + " ");
			  sb.append("Course Title: " + rs.getString("courseTitle") + " Teacher ID: " + rs.getString("teacherID"));
			  sb.append("\n");
		  }
		  return sb.toString();
		} catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
  }
  
  @GET
  @Path("{id}") // Read how  the path param is  used
  @Produces(MediaType.APPLICATION_JSON)
  public List<Course> getCourseById(@PathParam("id") String id) throws Exception {
	  List<Course> courses = new ArrayList();
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  ResultSet rs = stmt.executeQuery("SELECT * from courses WHERE courseID = '" + id + "'")  ;
	  while(rs.next()) {
		  Course  course = new Course(rs.getString("courseID"), rs.getString("courseTitle"), rs.getString("teacherID"));
		  courses.add(course);
	  }
	  return courses;
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Read  the significance of this
  @Produces(MediaType.APPLICATION_JSON)
  public  List<Course> saveCourse(@FormParam("courseID")String courseID, @FormParam("courseTitle")String courseTitle, @FormParam("teacherID")String teacherID) throws ModelValidationException, SQLException, ClassNotFoundException {
	  List<Course> courses = new ArrayList();
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  String id = "insert into courses (courseID,courseTitle, teacherID) "
				+ " values(" + "'" + courseID + "','" + courseTitle + "','" + teacherID + "')";
	  stmt.executeUpdate(id);
	  Course course = new Course(courseID, courseTitle, teacherID);
	  courses.add(course);
	  return courses;
	  
  }
  
  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteCourse(@PathParam("id") String id) throws Exception {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  System.out.println(stmt.executeUpdate("DELETE from courses WHERE courseID = '" + id + "'") + " rows deleted");
	  return  Response.ok().build();
  }

}