package com.actualcare.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.Diagnosis;
import com.actualcare.dao.DiagnosisDao;
import com.actualcare.dao.DiagnosisDaoImpl;

public class DiagnosisDaoTest {
	
	@Test(priority = 1)
	public void insertTest() {
		Diagnosis d = new Diagnosis();
		DiagnosisDao dDao = new DiagnosisDaoImpl();
		Assert.assertEquals(dDao.insert(d), 50);
	}

	@Test(priority = 2)
	public void returnTest() {
		Diagnosis d = new Diagnosis();
		DiagnosisDao dDao = new DiagnosisDaoImpl();
		int diagnosis_id = dDao.insert(d);
		Assert.assertEquals((dDao.returnDiagnosis(diagnosis_id)).getDiagnosis_id(), d.getDiagnosis_id());
	}

	@Test(priority = 3)
	public void returnDocTest() {
		Diagnosis d = new Diagnosis();
		DiagnosisDao dDao = new DiagnosisDaoImpl();
		Integer diagnosis_id = dDao.insert(d);
		Assert.assertEquals(dDao.returnDiagnosis(diagnosis_id).getDiagnosis_id(), diagnosis_id);
	}
	
	@Test(priority = 4)
	public void deleteTest() {
		Diagnosis d = new Diagnosis();
		DiagnosisDao dDao = new DiagnosisDaoImpl();
		int diagnosis_id = dDao.insert(d);
		dDao.delete(d);
		Assert.assertEquals(dDao.returnDiagnosis(diagnosis_id), null);
	}
}
