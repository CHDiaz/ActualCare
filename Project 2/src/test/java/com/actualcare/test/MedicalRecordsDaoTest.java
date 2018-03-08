package com.actualcare.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actualcare.beans.MedicalRecords;
import com.actualcare.dao.MedicalRecordsDao;
import com.actualcare.dao.MedicalRecordsDaoImpl;


/**
 * @author Christian Diaz
 *
 */
public class MedicalRecordsDaoTest {
	MedicalRecordsDao mDao = new MedicalRecordsDaoImpl();
	
	/** Test for the insert method of the MedicalRecordsDaoImpl class. **/
	@Test(priority = 1)
	public void insertTest() {
		
		File file = new File("testFile.txt");
		
		MedicalRecords m = new MedicalRecords(mDao.convertToByteArray(file), file.getName());
		int m_id = mDao.insert(m);
		Assert.assertEquals(mDao.returnMedicalRecords(m_id).getMr_id(), m.getMr_id());
		mDao.delete(m);
	}
	
	/** Test for delete method of MedicalRecordsDaoImpl**/
	@Test(priority = 2)
	public void deleteTest() {
		
		File file = new File("testFile.txt");
		
		MedicalRecords m = new MedicalRecords(mDao.convertToByteArray(file), file.getName());
		int m_id = mDao.insert(m);
		mDao.delete(m);
		Assert.assertEquals(mDao.returnMedicalRecords(m_id), null);
	}

	/** Test for return method of MedicalRecordsDaoImpl**/
	@Test(priority = 3)
	public void returnTest() {
		
		File file = new File("testFile.txt");
		MedicalRecords m = new MedicalRecords(mDao.convertToByteArray(file), file.getName());
		
		int m_id = mDao.insert(m);
		Assert.assertEquals(mDao.returnMedicalRecords(m_id).getMr_id(), m.getMr_id());
		mDao.delete(m);
	}

	/** Test for returnAll method of MedicalRecordsDaoImpl**/
	@Test(priority = 4)
	public void returnAllTest() {
		
		File file1 = new File("testFile.txt");
		File file2 = new File("testFile.txt");
		
		MedicalRecords m1 = new MedicalRecords(mDao.convertToByteArray(file1), file1.getName());
		MedicalRecords m2 = new MedicalRecords(mDao.convertToByteArray(file2), file2.getName());
		
		mDao.insert(m1);
		mDao.insert(m2);
		List<MedicalRecords> testList = mDao.returnAllMedicalRecords();
		Assert.assertNotEquals(null, testList);
		mDao.delete(m1);
		mDao.delete(m2);
	}
	
	/** Test for both convert methods of MedicalRecordsDaoImpl**/
	@Test(priority = 5)
	public void convertTest() {
		
		File file1 = new File("testFile.txt");
		MedicalRecords m = new MedicalRecords(mDao.convertToByteArray(file1), file1.getName());
		
		File file2 = mDao.convertToFile(m);
		try {
			Assert.assertEquals(FileUtils.contentEquals(file1, file2), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mDao.delete(m);
	}
}
