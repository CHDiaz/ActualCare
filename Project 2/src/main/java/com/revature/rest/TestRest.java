package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.actualcare.beans.Test;

@Path("/test") //http://localhost:8085/ActualCare/rest/test
public class TestRest {
	
	@GET
	@Path("/get")//http://localhost:8085/ActualCare/rest/test/get
	@Produces(MediaType.APPLICATION_JSON)
	public List<Test> getAllTest(){
		
		List<Test> test = new ArrayList<>();
		
		test.add(new Test(1,"harish"));
		test.add(new Test(2,"christian"));
		test.add(new Test(3,"steven"));
		
		return test;
	}
	
	@GET
	@Path("/get/{testId}")////http://localhost:8085/ActualCare/rest/test/get/id
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTestIndex(@PathParam("testId") int id){
		
		List<Test> test = getAllTest();
		
		if(test.size()<id){
			return null;
		}
		
		return test.get(id-1);
	}
	
//	@PUT
//	@Path("/get/{testId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Test updateTestIndex(@PathParam("testId") int id){
//		
//		List<Test> test = getAllTest();
//		
//		if(test.size()<id){
//			return null;
//		}
//		
//		return test.get(id-1);
//	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	@Path("/post")
//	public String insertEmployee(Employee emp){
//		
//		System.out.println(emp);
//		emps.add(emp);
//		return "Success";
//	}	

}
