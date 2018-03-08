package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Diagnosis;
import com.actualcare.util.HibernateUtil;

public class DiagnosisDaoImpl implements DiagnosisDao{
	
	private static Logger logger = Logger.getLogger(DiagnosisDaoImpl.class);

	public int insert(Diagnosis d) {
		logger.info("DiagnosisDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int diagnosis_id = 0;

		try {
			tx = session.beginTransaction();
			diagnosis_id = (int) session.save(d);
			tx.commit();
			logger.info("Diagnosis object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Diagnosis object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return diagnosis_id;
	}

	public void delete(Diagnosis d) {
		logger.info("DiagnosisDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(d);
			tx.commit();
			logger.info("Diagnosis record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Diagnosis object");
		} finally {
			session.close();
		}
	}
		
	public Diagnosis returnDiagnosis(int diagnosis_id) {
		logger.info("DiagnosisDaoImpl returnDiagnosis method called.");
		Diagnosis diagnosis = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			diagnosis = (Diagnosis) session.createCriteria(Diagnosis.class).add(Restrictions.idEq(diagnosis_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Diagnosis object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Diagnosis object returned successfully.");
		return diagnosis;
	}	
	
	public Diagnosis getDiagnosisByPatId(Integer patient){
			Diagnosis diagnosis = null;
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				
				tx = session.beginTransaction();
				System.out.println("Grabbing the object for the first time...");
				diagnosis = (Diagnosis)session.get(Diagnosis.class, patient);
				
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
			return diagnosis;
	}
}
