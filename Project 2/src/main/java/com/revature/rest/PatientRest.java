package com.revature.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.actualcare.beans.Patient;
import com.actualcare.dao.AllergyDao;
import com.actualcare.dao.AllergyDaoImpl;
import com.actualcare.dao.PatientDao;
import com.actualcare.dao.PatientDaoImpl;
import com.actualcare.dao.PersonalInfoDao;
import com.actualcare.dao.PersonalInfoDaoImpl;

@Path("/patient")
public class PatientRest {
	PatientDao pDao = new PatientDaoImpl();
	PersonalInfoDao peDao = new PersonalInfoDaoImpl();
	AllergyDao agDao = new AllergyDaoImpl();
	
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	public void insertRegistered(Patient p){
		pDao.insertRegister(p);
	}

}
