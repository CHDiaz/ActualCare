package com.revature.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

@Path("/patient")
public class PatientRest {
	PatientDao pDao = new PatientDaoImpl();
	InsuranceDao iDao = new InsuranceDaoImpl();
	PersonalInfoDao peDao = new PersonalInfoDaoImpl();
	AllergyDao agDao = new AllergyDaoImpl();
	
	
	@POST
	@Path("/post")//http://localhost:8085/ActualCare/rest/patient/post
	@Produces(MediaType.APPLICATION_JSON)
	public void insertRegistered(Patient p){
		pDao.insertRegister(p);								// Insert this new patient into the table.
		
		String i_name = p.getMyInsurance().getI_name();     // Extract the insurance name from the patient object
		Insurance i = iDao.returnInsuranceByName(i_name);	// Search for the corresponding Insurance record in the Insurance table
		i.addPatient(p); 									// Add this new patient to the this Insurance object's set of patients
		iDao.updatePatientList(i);							// Update the Insurance object to include this new patient
		p.setMyInsurance(i);								// Set the new value for Patient p's myInsurance.
		
		String d_name = p.getPCP().getName();				// Extract the Doctor name from the patient object
		Doctor d = DoctorDao.returnDoctorByName(d_name);	// Search for the corresponding Doctor record in the Doctor table
		d.addPatient(p); 									// Add this new patient to this Doctor object's set of patients
		DoctorDao.updatePatientList(d);						// Update the Doctor object to include this new patient
		p.setPCP(d);										// Set the new value for the Patient p's PCP.
		
	
	}

}
