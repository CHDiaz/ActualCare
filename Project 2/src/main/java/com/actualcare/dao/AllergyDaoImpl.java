package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Allergy;
import com.actualcare.util.HibernateUtil;


public class AllergyDaoImpl implements AllergyDao {
	private static Logger logger = Logger.getLogger(AllergyDaoImpl.class);

	public int insert(Allergy a) {
		logger.info("AllergyDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int allergy_id = 0;

		try {
			tx = session.beginTransaction();
			allergy_id = (int) session.save(a);
			tx.commit();
			logger.info("Allergy object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Allergy object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return allergy_id;
	}

	public void delete(Allergy a) {
		logger.info("AllergyDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(a);
			tx.commit();
			logger.info("Allergy record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Allergy object");
		} finally {
			session.close();
		}
	}
		
	public Allergy returnAllergy(int allergy_id) {
		logger.info("AllergyDaoImpl returnAllergy method called.");
		Allergy allergy = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			allergy = (Allergy) session.createCriteria(Allergy.class).add(Restrictions.idEq(allergy_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Allergy object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Allergy object returned successfully.");
		return allergy;
	}	
	
	public Allergy getAllergyByPatId(Integer patient){
			Allergy allergy = null;
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				
				tx = session.beginTransaction();
				System.out.println("Grabbing the object for the first time...");
				allergy = (Allergy)session.get(Allergy.class, patient);
				
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
			return allergy;
	}
	
}

	