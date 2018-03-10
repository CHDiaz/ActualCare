package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.actualcare.beans.Doctor;
import com.actualcare.beans.Insurance;
import com.actualcare.dao.InsuranceDao;
import com.actualcare.dao.InsuranceDaoImpl;

@Path("/insurance")
public class InsuranceRest {
	
	InsuranceDao iDao = new InsuranceDaoImpl();
	
	@GET
	@Path("/get/{iname}")//http://localhost:8085/ActualCare/rest/insurance/get/WELL_CARE
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> returnDoctorsByInsurance(@PathParam("iname")String i_name){
		Insurance i = iDao.returnInsuranceByName(i_name);
		System.out.println(i);
		List<Doctor> dlist = new ArrayList<Doctor>();
		dlist.addAll(i.getDoctorList());
		return dlist;
	}

}
