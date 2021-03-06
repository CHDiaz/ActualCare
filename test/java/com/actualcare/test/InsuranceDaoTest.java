package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Insurance;
import com.actualcare.dao.InsuranceDao;
import com.actualcare.dao.InsuranceDaoImpl;

public class InsuranceDaoTest {
	@Test(priority = 1)
	public void insertTest() {
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		Assert.assertEquals(iDao.insert(i), 50);
	}

	@Test(priority = 2)
	public void returnTest() {
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		int insurance_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(insurance_id)).getInsurance_id(), i.getInsurance_id());
	}
	
	@Test(priority = 3)
	public void returnDocTest() {
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		int insurance_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(insurance_id)).getDoctor(), i.getDoctor().getD_Id);
	}
	
	@Test(priority = 4)
	public void returnPatTest() {
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		int insurance_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(insurance_id)).getPatient(), i.getPatient().getP_Id());
	}
	
	@Test(priority = 5)
	public void deleteTest() {
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		int insurance_id = iDao.insert(i);
		iDao.delete(i);
		Assert.assertEquals(iDao.returnInsurance(insurance_id), null);
	}

}
