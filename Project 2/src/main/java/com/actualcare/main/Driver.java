package com.actualcare.main;

import org.testng.Assert;

import com.actualcare.beans.Insurance;
import com.actualcare.beans.Treatment;
import com.actualcare.dao.InsuranceDao;
import com.actualcare.dao.InsuranceDaoImpl;
import com.actualcare.dao.TreatmentDao;
import com.actualcare.dao.TreatmentDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
	/*	// Patient login data insert test
		Patient p = new Patient((new LoginInfo("harish@com","harish")));
		PatientDao.insertPatient(p);
		
		// Doctor login data insert test
		Doctor d = new Doctor((new LoginInfo("christian@com","christian")));
		DoctorDao.insertDoctor(d);
		
		// Admin login data insert test
		Admin a = new Admin((new LoginInfo("steven@com","steven")));
		AdminDao.insertAdmin(a);*/
		
		// Treatement data insert test
/*		Treatment t = new Treatment("test");
		TreatmentDao tDao = new TreatmentDaoImpl();
		int id = tDao.insert(t);
		System.out.println(id);
		
		Treatment t1 = tDao.returnTreatment(id);
		System.out.println(t1.getT_id());
		System.out.println(t.getT_id());*/

		/*Insurance insurance = new Insurance("test");
		InsuranceDao iDao =  new InsuranceDaoImpl();
		int id = iDao.returnInsurance(insurance);
		System.out.println(id);
		*/
	
	/*	
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		Integer i_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(i_id)).getDoctor(), i.getDoctor().getD_Id());
	*/	
		Insurance i = new Insurance("test");		InsuranceDao iDao = new InsuranceDaoImpl();
		Integer i_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(i_id)).getPatient(), i.getPatient().getP_Id());
		
	}

}