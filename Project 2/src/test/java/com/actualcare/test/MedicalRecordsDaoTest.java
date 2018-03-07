package com.actualcare.test;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actualcare.beans.MedicalRecords;
import com.actualcare.dao.MedicalRecordsDao;
import com.actualcare.dao.MedicalRecordsDaoImpl;

public class MedicalRecordsDaoTest {
	MedicalRecordsDao tDao = new MedicalRecordsDaoImpl();
	
	/** Test for the insert method of the TreatmentDaoImpl class. **/
	@Test(priority = 1)
	public void insertTest() {
		
		File file = new File("C:\\Users\\Christian Diaz\\Desktop\\180212\\Project2-Pipeline\\Project 2\\src\\test\\java\\com\\actualcare\\test\\testFile.txt");
		
		MedicalRecords m = new MedicalRecords(tDao.convertToBlob(file), file.getName());
		int id = tDao.insert(m);
		Assert.assertEquals(id, 50);
	}
		
	



/*	public int insert(MedicalRecords m);
	public void delete(MedicalRecords m);
	public MedicalRecords returnMedicalRecords(int m_id);
	public File convertToFile(MedicalRecords m);
	public File getFile(int m_id);*/
}
