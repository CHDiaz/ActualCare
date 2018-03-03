package com.actualcare.main;

import com.actualcare.beans.Admin;
import com.actualcare.beans.Doctor;
import com.actualcare.beans.LoginInfo;
import com.actualcare.beans.Patient;
import com.actualcare.dao.AdminDao;
import com.actualcare.dao.DoctorDao;
import com.actualcare.dao.PatientDao;

public class Driver {

	public static void main(String[] args) {
		
		// Patient login data insert test
		Patient p = new Patient((new LoginInfo("harish@com","harish")));
		PatientDao.insertPatient(p);
		
		// Doctor login data insert test
		Doctor d = new Doctor((new LoginInfo("christian@com","christian")));
		DoctorDao.insertDoctor(d);
		
		// Admin login data insert test
		Admin a = new Admin((new LoginInfo("steven@com","steven")));
		AdminDao.insertAdmin(a);

	}

}
