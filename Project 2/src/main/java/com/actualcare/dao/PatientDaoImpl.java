package com.actualcare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Allergy;
import com.actualcare.beans.Patient;
import com.actualcare.beans.Sympton;
import com.actualcare.util.HibernateUtil;

/**
 * @author Christian Diaz
 *
 */
public class PatientDaoImpl implements PatientDao {
	private static Logger logger = Logger.getLogger(PatientDaoImpl.class);

	/**
	 * Method for inserting a record into the Patients table, based on the
	 * provided Patient object.
	 **/
	public int insert(Patient p) {
		logger.info("PatientDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int patient_id = 0;

		try {
			tx = session.beginTransaction();
		/*	session.save(p.getLogin());
			session.save(p.getMyInsurance());
			session.save(p.getMyMedications());
			session.save(p.getMyPersonalInfo());
			session.save(p.getMyMedications());
			session.save(p.getLogin());*/
			//session.save(p.getMedicalHistory());
			//session.save(p.getMedicalTests());
			//session.save(p.getMyAppointments());
			session.save(p.getMyAllgeries());
			session.save(p.getMySymptons());
			patient_id = (int) session.save(p);
			tx.commit();
			logger.info("Patient object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Patient object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return patient_id;
	}
	
	/**
	 * Method for inserting a record after registering into the Patients table, based on the
	 * provided Patient object.
	 **/
	public int insertRegister(Patient p) {
		logger.info("PatientDaoImpl insertRegister method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int patient_id = 0;

		try {
			tx = session.beginTransaction();
			session.save(p.getLogin());
			session.save(p.getMyPersonalInfo());
			session.save(p.getMyAllgeries());
			session.save(p.getMySymptons());
			patient_id = (int) session.save(p);
			tx.commit();
			logger.info("Patient object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Patient object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return patient_id;
	}
	
	/**
	 * Method for inserting a record after registering into the Patients table, based on the
	 * provided Patient object.
	 **/
	public void updateAllergy(Patient p, String allergy) {
		logger.info("PatientDaoImpl insertRegister method called.");

		if(p.getMyAllgeries() == null) {
			Allergy a = new Allergy(allergy);
			p.setMyAllgeries(a);
		}else {
			p.getMyAllgeries().setA_name(allergy);
		}
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(p.getMyAllgeries());
			session.update(p);
			tx.commit();
			logger.info("Patient object updated with new Allergy successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Patient object was NOT upated with new Allergy");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * Method for inserting a record after registering into the Patients table, based on the
	 * provided Patient object.
	 **/
	public void updateSympton(Patient p, String sympton) {
		logger.info("PatientDaoImpl insertRegister method called.");

		if(p.getMySymptons() == null) {
			 Sympton s = new Sympton(sympton);
			p.setMySymptons(s);
		}else {
			p.getMySymptons().setS_name(sympton);;
		}
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(p.getMySymptons());
			session.update(p);
			tx.commit();
			logger.info("Patient object updated with new Allergy successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Patient object was NOT upated with new Allergy");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	

	/**
	 * Method for deleting a record from the Patients table, based on the
	 * provided Patient object.
	 **/
	public void delete(Patient p) {
		logger.info("PatientDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(p);
			tx.commit();
			logger.info("Patient record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Patient object");
		} finally {
			session.close();
		}
		
	}

	/**
	 * Method for returning a record from the Patients table as a Patient object, 
	 * based on the provided Patient id.
	 **/
	public Patient returnPatient(int p_id) {
		logger.info("PatientDaoImpl returnAllergy method called.");
		Patient patient = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			patient = (Patient) session.createCriteria(Patient.class).add(Restrictions.idEq(p_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Patient object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Patient object returned successfully.");
		return patient;
	}
	
	/**
	 * Method for returning a record from the Patients table as a Patient object, 
	 * based on the provided Patient id.
	 **/
	public Patient returnPatientByLoginId(int l_id) {
		logger.info("PatientDaoImpl returnAllergy method called.");
		Patient patient = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			patient = (Patient) session.createCriteria(Patient.class).createAlias("login", "l").add(Restrictions.eq("l.Login_id", l_id))  .uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Patient object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Patient object returned successfully.");
		return patient;
	}

	/**
	 * Method for returning all records from the Patients table as a list of Patients.
	 **/
	public List<Patient> returnAllPatients() {
		logger.info("PatientDaoImpl returnAllPatient method called.");
		List<Patient> allPatientList = new ArrayList<Patient>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			allPatientList = session.createQuery("FROM Patient").list();
			logger.info("All patient objects obtained");
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
				logger.info("PatientDaoImpl was UNABLE to return all patient");
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return allPatientList;
	}

}
