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

@Path("/teachers")
public class TeacherAPI {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getTeacher() {
	  try {
		  StringBuilder sb = new StringBuilder();
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
		  Statement stmt = connection.createStatement();
		  ResultSet rs = stmt.executeQuery("SELECT * from teacher");
		  while(rs.next()) {
			  sb.append("Teacher ID: " + rs.getInt("teacherID") + " ");
			  sb.append("Name: " + rs.getString("teacherName"));
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
  public List<Teacher> getTeacherById(@PathParam("id") String id) throws Exception {
	  List<Teacher> teachers = new ArrayList();
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  ResultSet rs = stmt.executeQuery("SELECT * from teacher WHERE teacherID = '" + id + "'")  ;
	  while(rs.next()) {
		  Teacher  teacher = new Teacher(rs.getString("teacherID"), rs.getString("teacherName"));
		  teachers.add(teacher);
	  }
	  return teachers;
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Read  the significance of this
  @Produces(MediaType.APPLICATION_JSON)
  public  List<Teacher> saveTeacher(@FormParam("teacherID")String teacherID, @FormParam("teacherName")String teacherName) throws ModelValidationException, SQLException, ClassNotFoundException {
	  List<Teacher> teachers = new ArrayList();
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  String id = "insert into teacher (teacherID,teacherName) "
				+ " values(" + "'" + teacherID + "','" + teacherName + "')";
	  stmt.executeUpdate(id);
	  Teacher teacher = new Teacher(teacherID, teacherName);
	  teachers.add(teacher);
	  return teachers;
	  
  }
  
  // This method is called if XML is request
  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteTeacher(@PathParam("id") String id) throws Exception {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_loop?serverTimezone=UTC", "loop", "loop");
	  Statement stmt = connection.createStatement();
	  stmt.executeUpdate("DELETE from teacher WHERE teacherID = '" + id + "'");
	  return  Response.ok().build();
  }

}