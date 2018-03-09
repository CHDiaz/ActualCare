package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Allergy;
import com.actualcare.dao.AllergyDao;
import com.actualcare.dao.AllergyDaoImpl;

public class AllergyDaoTest {
	
	@Test(priority = 1)
	public void insertTest() {
		Allergy a = new Allergy("test");
		AllergyDao aDao = new AllergyDaoImpl();
		Assert.assertEquals(aDao.insert(a), 50);
	}

	
	@Test(priority = 2)
	public void returnTest() {
		Allergy a = new Allergy("test");
		AllergyDao aDao = new AllergyDaoImpl();
		Integer allergy_id = aDao.insert(a);
		Assert.assertEquals(aDao.returnAllergy(allergy_id).getA_id(), allergy_id);
	}
	
	@Test(priority = 3)
	public void deleteTest() {
		Allergy a = new Allergy("test");
		AllergyDao aDao = new AllergyDaoImpl();
		int allergy_id = aDao.insert(a);
		aDao.delete(a);
		Assert.assertEquals(aDao.returnAllergy(allergy_id), null);
	}

}
