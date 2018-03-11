package com.actualcare.main;

import com.actualcare.beans.Allergy;
import com.actualcare.beans.LoginInfo;
import com.actualcare.beans.Patient;
import com.actualcare.beans.PersonalInfo;
import com.actualcare.beans.Sympton;
import com.actualcare.dao.PatientDao;
import com.actualcare.dao.PatientDaoImpl;


public class Driver {

	public static void main(String[] args) {
		PatientDao pDao = new PatientDaoImpl();
		Patient p = new Patient("WELL_CARE", "BOBBERT", new LoginInfo(), new PersonalInfo() );
		p.setMyAllgeries(new Allergy("No Allergies yet"));
		p.setMySymptons(new Sympton("No symptoms yet"));
		pDao.insertRegister(p);
		System.out.println("==========================");
		pDao.delete(p);
		System.exit(0);
		
	}
	
}
