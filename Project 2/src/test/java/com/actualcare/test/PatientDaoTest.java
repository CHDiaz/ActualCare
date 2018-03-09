package com.actualcare.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Patient;
import com.actualcare.dao.PatientDao;
import com.actualcare.dao.PatientDaoImpl;

public class PatientDaoTest {
	PatientDao pDao = new PatientDaoImpl();
	
	/** Test for the insert method of the PatientDaoImpl class. **/
	@Test(priority = 1)
	public void insertTest() {
		Patient p = new Patient();
		int p_id = pDao.insert(p);
		Assert.assertEquals(pDao.returnPatient(p_id).getP_id(), p.getP_id());
		pDao.delete(p);
	}

	/** Test for the return method of the PatientDaoImpl class. **/
	@Test(priority = 2)
	public void returnTest() {
		Patient p = new Patient();
		int p_id = pDao.insert(p);
		Assert.assertEquals((pDao.returnPatient(p_id)).getP_id(), p.getP_id());
		pDao.delete(p);
	}

	/** Test for the delete method of the PatientDaoImpl class. **/
	@Test(priority = 3)
	public void deleteTest() {
		Patient p = new Patient();
		int p_id = pDao.insert(p);
		pDao.delete(p);
		Assert.assertEquals(pDao.returnPatient(p_id), null);
	}
	
	/** Test for the return all method of the PatientDaoImpl class. **/
	@Test(priority = 4)
	public void returnAllTest() {
		Patient p = new Patient();
		Patient p2 = new Patient();
		pDao.insert(p);
		pDao.insert(p2);
		List<Patient> testList = pDao.returnAllPatients();
		Assert.assertNotEquals(null, testList);
		pDao.delete(p);
		pDao.delete(p2);
	}
}
