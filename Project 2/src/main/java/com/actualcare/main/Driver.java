package com.actualcare.main;

import com.actualcare.beans.Admin;
import com.actualcare.beans.Doctor;
import com.actualcare.beans.LoginInfo;
import com.actualcare.beans.Patient;
import com.actualcare.beans.Treatment;
import com.actualcare.dao.AdminDao;
import com.actualcare.dao.DoctorDao;
import com.actualcare.dao.LoginInfoDao;
import com.actualcare.dao.PatientDao;
import com.actualcare.dao.TreatmentDao;
import com.actualcare.dao.TreatmentDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		// Patient login data insert test
		Patient p = new Patient((new LoginInfo("harish@com","harish","patient")));
		PatientDao.insertPatient(p);
		
		// Doctor login data insert test
		Doctor d = new Doctor((new LoginInfo("christian@com","christian","doctor")));
		DoctorDao.insertDoctor(d);
		
		// Admin login data insert test
		Admin a = new Admin((new LoginInfo("steven@com","steven","admin")));
		AdminDao.insertAdmin(a);
		
//		// Treatement data insert test
//		Treatment t = new Treatment("test");
//		TreatmentDao tDao = new TreatmentDaoImpl();
//		int id = tDao.insert(t);
//		System.out.println(id);
//		
//		Treatment t1 = tDao.returnTreatment(id);
//		System.out.println(t1.getT_id());
//		System.out.println(t.getT_id());
		
		System.out.println(LoginInfoDao.getAllLogin());
		

	}

}