package com.actualcare.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.actualcare.beans.Test;
import com.google.gson.Gson;

/**
 * Servlet implementation class helloworld
 */
public class helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In helloworld servlet");
		
		List<Test> test = new ArrayList();
		test.add(new Test(1,"harish"));
		test.add(new Test(2,"christian"));
		test.add(new Test(3,"steven"));
		
		String json = new Gson().toJson(test);
		   response.setContentType("application/json");
		   response.setCharacterEncoding("UTF-8");
		   response.getWriter().write(json);
		
		System.out.println("profavor");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>UNAUTHOTORIZED ACCESS! FBI HAS BEEN ALERTED!</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
