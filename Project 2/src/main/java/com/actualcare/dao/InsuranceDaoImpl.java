package com.actualcare.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Insurance;
import com.actualcare.beans.Treatment;
import com.actualcare.util.HibernateUtil;

public class InsuranceDaoImpl implements InsuranceDao {
	private static Logger logger = Logger.getLogger(InsuranceDaoImpl.class);

	/**
	 * Method that inserts an Insurance record into the Insurance table, based on
	 * the specificed Insurance object.
	 **/
	public int insert(Insurance i) {
		logger.info("InsuranceDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int insurance_id = 0;

		try {
			tx = session.beginTransaction();
			insurance_id = (int) session.save(i);
			tx.commit();
			logger.info("Insurance object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Insurance object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return insurance_id;
	}

	/**
	 * Method that deletes an Insurance record from the Insurance table, based on
	 * the specificed Insurance object.
	 **/
	public void delete(Insurance i) {
		logger.info("InsuranceDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(i);
			tx.commit();
			logger.info("Insurance record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Insurance object");
		} finally {
			session.close();
		}

	}

	/**
	 * Method that returns an Insurance record from the Insurance table, based on
	 * the specificed Insurance i_id.
	 **/
	public Insurance returnInsurance(int insurance_id) {
		logger.info("InsuranceDaoImpl returnTreatment method called.");
		Insurance insurance = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			insurance = (Insurance) session.createCriteria(Insurance.class).add(Restrictions.idEq(insurance_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Insurance object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Insurance object returned successfully.");
		return insurance;
	}

	/** Method that returns all Insurance records from the Insurance table. **/
	public List<Insurance> returnAllInsurance() {
		logger.info("InsuranceDaoImpl returnAllInsurance method called.");
		List<Insurance> allinsuranceList = new ArrayList<Insurance>();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			allinsuranceList = session.createQuery("FROM Insurance").list();
			logger.info("All Insurance objects obtained");
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
				logger.info("InsuranceDaoImpl was UNABLE to return all Insurance");
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return allinsuranceList;
	}

}
