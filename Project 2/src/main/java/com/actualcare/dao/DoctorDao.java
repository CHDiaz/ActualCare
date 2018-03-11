package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Doctor;
import com.actualcare.beans.Insurance;
import com.actualcare.util.HibernateUtil;

public class DoctorDao {
	
	private static Logger logger = Logger.getLogger(DoctorDao.class);
	
	//saving login and then doctor data 
	public static void insertDoctor(Doctor d) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(d.getLogin());
		session.save(d);
			
		tx.commit();
		session.close();
	}
	
	public static Doctor returnDoctorByName(String dName) {
		logger.info("DoctorDao returnInsuranceByName method called.");
		Doctor  doctor = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			doctor = (Doctor) session.createCriteria(Doctor.class).add( Restrictions.like("name", dName) ).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Doctor object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Doctor object returned successfully.");
		return doctor;
	}
	
	public static void updatePatientList(Doctor d) {
		logger.info("DoctorDao updatePatient method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(d);;
			tx.commit();
			logger.info("Doctor object updated successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Doctor object was NOT updated!");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	
}
	
}