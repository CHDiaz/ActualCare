package com.actualcare.main;

import com.actualcare.beans.Admin;
import com.actualcare.beans.LoginInfo;
import com.actualcare.beans.Patient;
import com.actualcare.dao.AdminDao;
import com.actualcare.dao.LoginInfoDao;
import com.actualcare.dao.PatientDaoImpl;

public class Driver {

	public static void main(String[] args) {
		
		// Patient login data insert test
		Patient p = new Patient((new LoginInfo("harish@com","harish","patient")));
		PatientDaoImpl pp = new PatientDaoImpl();
		pp.insert(p);
		
		// Doctor login data insert test
/*		Doctor d = new Doctor((new LoginInfo("christian@com","christian","doctor")));
		DoctorDao.insertDoctor(d);*/
		
		// Admin login data insert test
		Admin a = new Admin((new LoginInfo("steven@com","steven","admin")));
		AdminDao.insertAdmin(a);
		
//		// Treatement data insert test
//		Treatment t = new Treatment("test");
//		TreatmentDao tDao = new TreatmentDaoImpl();
//		int id = tDao.insert(t);
//		System.out.println(id);
//		
//		Treatment t1 = tDao.returnTreatment(id);
//		System.out.println(t1.getT_id());
//		System.out.println(t.getT_id());
		System.out.println(LoginInfoDao.getAllLogin());
		// Treatment data insert test
/*		Treatment t = new Treatment("test");
		TreatmentDao tDao = new TreatmentDaoImpl();
		int id = tDao.insert(t);
		System.out.println(id);

		/*Insurance insurance = new Insurance("test");
		InsuranceDao iDao =  new InsuranceDaoImpl();
		int id = iDao.returnInsurance(insurance);
		System.out.println(id);
		*/
	
	/*	
		Insurance i = new Insurance("test");
		InsuranceDao iDao = new InsuranceDaoImpl();
		Integer i_id = iDao.insert(i);
		Assert.assertEquals((iDao.returnInsurance(i_id)).getDoctor(), i.getDoctor().getD_Id());
	*/	
/*		MedicalRecordsDao mrDao = new MedicalRecordsDaoImpl();
		MedicalRecords m = new MedicalRecords();
		
		File file1 = new File("testFile.txt");
		File file2 = new File("./testFile.txt");
		System.out.println("==========Do file1 qnd file2 esxit?===========");
		System.out.println(file1.exists());
		System.out.println(file2.exists());
		System.out.println("==========How do file1 and file2 compare?===========");
		System.out.println(file1.lastModified());
		System.out.println(file2.lastModified());
		
		byte[] buff2 = mrDao.convertToByteArray(file2);

		m.setFileName(file2.getName());
		m.setMedicalRecords(buff2);
		System.out.println("========Converting buff into file3============");
		File file3 = mrDao.convertToFile(m);
		
		System.out.println("========What are file, file2, file 3?============");
		System.out.println(file1.length());
		System.out.println(file2.length());
		System.out.println(file3.length());
		System.out.println("==========Are file and file3 equal?===========");
		try {
			System.out.println(FileUtils.contentEquals(file1, file3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	
	}
	
}