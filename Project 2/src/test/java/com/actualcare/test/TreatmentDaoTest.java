package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Treatment;
import com.actualcare.dao.TreatmentDao;
import com.actualcare.dao.TreatmentDaoImpl;

/**
 * @author Christian Diaz
 *
 */
public class TreatmentDaoTest {

	/** Test for the insert method of the TreatmentDaoImpl class. **/
	@Test(priority = 1)
	public void insertTest() {
		Treatment t = new Treatment("test");
		TreatmentDao tDao = new TreatmentDaoImpl();
		Assert.assertEquals(tDao.insert(t), 50);
	}

	/** Test for the return method of the TreatmentDaoImpl class. **/
	@Test(priority = 2)
	public void returnTest() {
		Treatment t = new Treatment("test");
		TreatmentDao tDao = new TreatmentDaoImpl();
		int t_id = tDao.insert(t);
		Assert.assertEquals((tDao.returnTreatment(t_id)).getT_id(), t.getT_id());
	}

	/** Test for the delete method of the TreatmentDaoImpl class. **/
	@Test(priority = 3)
	public void deleteTest() {
		Treatment t = new Treatment("test");
		TreatmentDao tDao = new TreatmentDaoImpl();
		int t_id = tDao.insert(t);
		tDao.delete(t);
		Assert.assertEquals(tDao.returnTreatment(t_id), null);
	}

}
