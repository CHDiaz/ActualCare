package com.actualcare.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.MedicalRecords;
import com.actualcare.util.HibernateUtil;

/**
 * @author Christian Diaz
 *
 */
public class MedicalRecordsDaoImpl implements MedicalRecordsDao {

	private static Logger logger = Logger.getLogger(MedicalRecordsDaoImpl.class);

	/**
	 * Method for inserting a record into the MedicalRecords table, based on the
	 * provided MedicalRecords object.q
	 **/
	public int insert(MedicalRecords m) {
		logger.info("MedicalRecordsDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int m_id = 0;

		try {
			tx = session.beginTransaction();
			m_id = (int) session.save(m);
			tx.commit();
			logger.info("MedicalRecords object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("MedicalRecords object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return m_id;
	}

	/**
	 * Method that deletes a MedicalRecords record from the database that matches
	 * the provided MedicalRecords object.
	 **/
	public void delete(MedicalRecords m) {
		logger.info("MedicalRecordsDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(m);
			tx.commit();
			logger.info("MedicalRecords record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete MedicalRecords object");
		} finally {
			session.close();
		}

	}

	/**
	 * Method for search through the MedicalRecords table for a specific m_id and
	 * returning the record as an object if it exists.
	 **/
	public MedicalRecords returnMedicalRecords(int m_id) {
		logger.info("MedicalRecordsDaoImpl returnMedicalRecords method called.");

		MedicalRecords medicalRecords = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			medicalRecords = (MedicalRecords) session.createCriteria(MedicalRecords.class).add(Restrictions.idEq(m_id))
					.uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("MedicalRecords object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("MedicalRecords object returned successfully.");
		return medicalRecords;
	}
	
	/**
	 * Method for returning all MedicalRecords records as a list.
	 **/
	public List<MedicalRecords> returnAllMedicalRecords() {
		logger.info("MedicalRecordsDaoImpl returnAllMedicalRecords method called.");
		List<MedicalRecords> medicalRecordsList = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			medicalRecordsList = session.createQuery("FROM MedicalRecords").list();
			logger.info("All MedicalRecords objects obtained");
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
				logger.info("MedicalRecordsDaoImpl was UNABLE to return all Treatments");
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return medicalRecordsList;
	}

	/**
	 * Method that will take a MedicalRecords byte array and convert it into a file
	 * that will be returned back to the user.
	 **/
	public File convertToFile(MedicalRecords m){
		logger.info("MedicalRecordsDaoImpl convertToFile method has been called.");

		byte[] buff = m.getMedicalRecords();		// Create byte array
		File file = new File(m.getFileName());		// get file name from MedicalRecords m
		
		try {
			logger.info("Blob will now be written into a file.");
			FileOutputStream fos = new FileOutputStream(file); 		 // Create new FileOutput stream with file
			fos.write(buff);										 // use fileoutputstream to write byte array to file
			fos.close();
		} catch (FileNotFoundException e) {
			logger.error("The file:" + m.getFileName() + " was NOT found!");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("The file:" + m.getFileName() + " could NOT be written!");
			e.printStackTrace();
		}

		return file;
	}	
	
	/**Method that will take a file object and convert it into a blob
	 * object so that it may inserted into a MedicalRecords object and 
	 * then be eligible for persistence in the database. 
	 * @throws  
	 **/
	public byte[] convertToByteArray(File f)  {
		logger.info("MedicalRecordsDaoImpl convertToByteArray method has been called.");
		byte[] buff = new byte[(int) f.length()];
		
		try {
			logger.info("MedicalRecordsDaoImpl convertToByteArray will attempt to convert file to byte[] now.");
			FileInputStream fis = new FileInputStream(f);
			fis.read(buff);
			fis.close();
		}
		catch(FileNotFoundException e) {
			logger.error("FILE NOT FOUND!");
			e.printStackTrace();
		}
		catch(IOException e) {
			logger.error("INPUT/OUTPUT ERROR!");
			e.printStackTrace();
			
		}catch (Exception e) {
			logger.error("Something went wrong?");
			e.printStackTrace();
		} 
		logger.info("MedicalRecordsDaoImpl is now return byte[] of file");
		
		return buff;
	}
	
	/** Method that returns a file associated with a m_id **/
	public File getFile(int m_id) {
		logger.info("MedicalRecordsDaoImpl getFile method has been called.");
		MedicalRecords medicalRecords = returnMedicalRecords(m_id);
		logger.info("File is being found, converted, and returned by getFile()");
		return convertToFile(medicalRecords);
	}
}
