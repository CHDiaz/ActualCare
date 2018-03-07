package com.revature.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.actualcare.beans.LoginInfo;
import com.actualcare.dao.LoginInfoDao;

@Path("/login")
public class LoginRest {
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LoginInfo> getAlllogin(){
		return LoginInfoDao.getAllLogin();
	}
}
