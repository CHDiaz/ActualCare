package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Sympton;
import com.actualcare.dao.SymptonDao;
import com.actualcare.dao.SymptonDaoImpl;

public class SymptonDaoTest {
	
	@Test(priority = 1)
	public void insertTest() {
		Sympton s = new Sympton("test");
		SymptonDao sDao = new SymptonDaoImpl();
		Assert.assertEquals(sDao.insert(s), 50);
	}

	
	@Test(priority = 2)
	public void returnTest() {
		Sympton s = new Sympton("test");
		SymptonDao sDao = new SymptonDaoImpl();
		int sympton_id = sDao.insert(s);
		Assert.assertEquals((sDao.getSymptonByPatId(sympton_id)).getPatient(), s.getPatient().getP_Id());
	}
	
	@Test(priority = 3)
	public void deleteTest() {
		Sympton s = new Sympton("test");
		SymptonDao sDao = new SymptonDaoImpl();
		int sympton_id = sDao.insert(s);
		sDao.delete(s);
		Assert.assertEquals(sDao.returnSympton(sympton_id), null);
	}
}
