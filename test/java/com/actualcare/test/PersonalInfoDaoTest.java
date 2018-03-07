package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.PersonalInfo;
import com.actualcare.dao.PersonalInfoDao;
import com.actualcare.dao.PersonalInfoDaoImpl;



public class PersonalInfoDaoTest {
	@Test(priority = 1)
	public void insertTest() {
		PersonalInfo pi = new PersonalInfo("test");
		PersonalInfo piDao = new PersonalInfoImpl();
		Assert.assertEquals(piDao.insert(pi), 50);
	}

	@Test(priority = 2)
	public void returnTest() {
		PersonalInfo i = new PersonalInfo("test");
		PersonalInfoDao piDao = new PersonalInfoDaoImpl();
		int personal_id = piDao.insert(pi);
		Assert.assertEquals((piDao.returnInsurance(personal_id)).getPersonal_id(), pi.getPersonal_id());
	}

	@Test(priority = 3)
	public void deleteTest() {
		PersonalInfo i = new PersonalInfo("test");
		PersonalInfoDao piDao = new PersonalInfoDaoImpl();
		int personal_id = piDao.insert(pi);
		piDao.delete(pi);
		Assert.assertEquals(iDao.returnInsurance(personal_id), null);
	}

}
