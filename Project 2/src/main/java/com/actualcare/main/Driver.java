package com.actualcare.main;

import java.util.Set;

import com.actualcare.beans.Doctor;
import com.actualcare.beans.Insurance;
import com.actualcare.beans.LoginInfo;

public class Driver {

	public static void main(String[] args) {
		
		// Patient login data insert test
	/*	Patient p = new Patient((new LoginInfo("harish@com","harish","patient")));
		PatientDao.insert(p);*/
		
		// Doctor login data insert test
/*		Doctor d = new Doctor((new LoginInfo("christian@com","christian","doctor")));
		DoctorDao.insertDoctor(d);*/
		
		// Admin login data insert test
//		Admin a = new Admin((new LoginInfo("steven@com","steven","admin")));
//		AdminDao.insertAdmin(a);
		
//		// Treatement data insert test
//		Treatment t = new Treatment("test");
//		TreatmentDao tDao = new TreatmentDaoImpl();
//		int id = tDao.insert(t);
//		System.out.println(id);
//		
//		Treatment t1 = tDao.returnTreatment(id);
//		System.out.println(t1.getT_id());
//		System.out.println(t.getT_id());
//		System.out.println(LoginInfoDao.getAllLogin());
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
//		PatientDao pDao = new PatientDaoImpl();
//
//		
//		
//		Allergy myAllgeries = new Allergy("cats");
//		Set<Appointments> myAppointments =  new HashSet<Appointments>();
//		Set<Diagnosis> medicalHistory = null;
//		Insurance myInsurance = new Insurance("insurance a");
//		LoginInfo login = new LoginInfo("patient@Dog.com","password","patient");
//		Set<MedicalRecords> medicalTests = null;
//		PersonalInfo myPersonalInfo = new PersonalInfo();
//		Sympton mySymptons = new Sympton("I am sick");
//		Treatment myMedications = new Treatment("Vitamin D");
//		
//		
//		Patient p = new Patient();
//		p.setLogin();
//		
		
//		pDao.insert(p);
//		pDao.delete(p);
		
		//Insurance(String i_name, Set<Doctor> doctorList)
		Insurance i1 = new Insurance("UNITED_HEALTH");
		Insurance i2 = new Insurance("WELL_CARE");
		Insurance i3 = new Insurance("WELL_POINT");
		Insurance i4 = new Insurance("OSCAR");
		Insurance i5 = new Insurance("NO_INSURANCE");
		
		//LoginInfo(String email, String password, String role)
		LoginInfo l1 = new LoginInfo("manbert@dogmail.com","manbert","doctor");
		LoginInfo l2 = new LoginInfo("docman@dogmail.com", "docman","doctor");
		LoginInfo l3 = new LoginInfo("healing@dogmail.com","healing","doctor");
		LoginInfo l4 = new LoginInfo("stephanie@dogmail.com","stephanie","doctor");
		LoginInfo l5 = new LoginInfo("bobbert@dogmail.com","bobbert","doctor");
		
		//Doctor(String name, LoginInfo login)
		Doctor d1 = new Doctor("MANBERT", l1);
		Doctor d2 = new Doctor("DOCMAN", l2);
		Doctor d3 = new Doctor("HEALING", l3);
		Doctor d4 = new Doctor("STEPHANIE", l4);
		Doctor d5 = new Doctor("BOBBERT", l5) ;
		
		d1.addInsurance(i1);
		d1.addInsurance(i2);
		
		d2.addInsurance(i1);
		d2.addInsurance(i2);
		d2.addInsurance(i3);
		
		d3.addInsurance(i4);
		d3.addInsurance(i5);
		
		d4.addInsurance(i3);
		
		d5.addInsurance(i1);
		d5.addInsurance(i2);
		d5.addInsurance(i3);
		d5.addInsurance(i4);
		d5.addInsurance(i5);
	}
	
}