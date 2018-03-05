package com.actualcare.test;

import java.io.File;
import java.sql.Blob;

import org.testng.annotations.Test;

import com.actualcare.beans.MedicalRecords;
import com.actualcare.dao.MedicalRecordsDao;
import com.actualcare.dao.MedicalRecordsDaoImpl;

public class MedicalRecordsDaoTest {
  
	/** Test for the insert method of the TreatmentDaoImpl class. **/
	@Test(priority = 1)
	public void insertTest() {
		File file = new File("/ActualCare/src/main/resources/log4j.properties");
	}
/*		MedicalRecords m = new MedicalRecords(file, file.getName());
		MedicalRecordsDao tDao = new MedicalRecordsDaoImpl();
		//Assert.assertEquals(tDao.insert(t), 50);
	}



	public int insert(MedicalRecords m);
	public void delete(MedicalRecords m);
	public MedicalRecords returnMedicalRecords(int m_id);
	public File convertToFile(MedicalRecords m);
	public File getFile(int m_id);*/
}
