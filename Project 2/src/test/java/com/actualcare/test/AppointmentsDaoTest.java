package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Appointments;
import com.actualcare.dao.AppointmentsDao;
import com.actualcare.dao.AppointmentsDaoImpl;


public class AppointmentsDaoTest {

	@Test(priority = 1)
	public void insertTest() {
		Appointments a = new Appointments();
		AppointmentsDao aDao = new AppointmentsDaoImpl();
		Integer a_id = aDao.insert(a);
		Assert.assertEquals(aDao.returnAppointments(a_id).getApp_id(), a_id);
	}

	
	@Test(priority = 2)
	public void returnTest() {
		Appointments a = new Appointments();
		AppointmentsDao aDao = new AppointmentsDaoImpl();
		Integer a_id = aDao.insert(a);
		Assert.assertEquals(aDao.returnAppointments(a_id).getApp_id(), a_id);
	}
	
	@Test(priority = 3)
	public void deleteTest() {
		Appointments a = new Appointments();
		AppointmentsDao aDao = new AppointmentsDaoImpl();
		int a_id = aDao.insert(a);
		aDao.delete(a);
		Assert.assertEquals(aDao.returnAppointments(a_id), null);
	}
}
