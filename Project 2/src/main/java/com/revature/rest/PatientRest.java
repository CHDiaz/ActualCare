package com.revature.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.actualcare.beans.Doctor;
import com.actualcare.beans.Insurance;
import com.actualcare.beans.Patient;
import com.actualcare.dao.AllergyDao;
import com.actualcare.dao.AllergyDaoImpl;
import com.actualcare.dao.DoctorDao;
import com.actualcare.dao.InsuranceDao;
import com.actualcare.dao.InsuranceDaoImpl;
import com.actualcare.dao.PatientDao;
import com.actualcare.dao.PatientDaoImpl;
import com.actualcare.dao.PersonalInfoDao;
import com.actualcare.dao.PersonalInfoDaoImpl;
import com.actualcare.dao.SymptonDao;
import com.actualcare.dao.SymptonDaoImpl;

@Path("/patient")
public class PatientRest {
	PatientDao pDao = new PatientDaoImpl();
	InsuranceDao iDao = new InsuranceDaoImpl();
	PersonalInfoDao peDao = new PersonalInfoDaoImpl();
	AllergyDao agDao = new AllergyDaoImpl();
	SymptonDao sDao = new SymptonDaoImpl();
	
	@POST
	@Path("/post")//http://localhost:8085/ActualCare/rest/patient/post
	@Produces(MediaType.APPLICATION_JSON)
	public void insertRegistered(Patient p){
		System.out.println("In POST");
		
		String i_name = p.getMyInsurance();     // Extract the insurance name from the patient object
		Insurance i = iDao.returnInsuranceByName(i_name);	// Search for the corresponding Insurance record in the Insurance table
		i.addPatient(p); 									// Add this new patient to the this Insurance object's set of patients
		
		String d_name = p.getPCP();				// Extract the Doctor name from the patient object
		Doctor d = DoctorDao.returnDoctorByName(d_name);	// Search for the corresponding Doctor record in the Doctor table
		d.addPatient(p); 									// Add this new patient to this Doctor object's set of patients
		
		p.setPCP(d.getName());										// Set the new value for the Patient p's PCP.
		p.setMyInsurance(i.getI_name());								// Set the new value for Patient p's myInsurance.
		pDao.insertRegister(p);								// Insert this new patient into the table.
		iDao.updatePatientList(i);							// Update the Insurance object to include this new patient
		DoctorDao.updatePatientList(d);						// Update the Doctor object to include this new patient
	}
	
	
	@GET
	@Path("/get/{lid}")//http://localhost:8085/ActualCare/rest/patient/get/{lid}
	@Produces(MediaType.APPLICATION_JSON)
	public Patient getPatient(@PathParam("lid")int lid) {
		return pDao.returnPatientByLoginId(lid);
		
	}
	
	@GET
	@Path("/updatea/{lid}/{allergy}")//http://localhost:8085/ActualCare/rest/patient/updatea/{lid}/{allergy}
	@Produces(MediaType.APPLICATION_JSON)
	public void updateAllergy(@PathParam("lid")int login_id, @PathParam("allergy") String al) {
		Patient p = pDao.returnPatientByLoginId(login_id);
		pDao.updateAllergy(p, al);
		
	}
	@GET
	@Path("/updates/{lid}/{symptom}")//http://localhost:8085/ActualCare/rest/patient/updates/{lid}/{symptom}
	@Produces(MediaType.APPLICATION_JSON)
	public void updateSympton(@PathParam("lid")int login_id, @PathParam("symptom") String sy) {
		Patient p = pDao.returnPatientByLoginId(login_id);
		p.getMySymptons().setS_name(sy);;
	}

}
