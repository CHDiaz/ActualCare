package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Treatment;
import com.actualcare.util.HibernateUtil;

/**
 * @author Christian Diaz
 *
 */
public class TreatmentDaoImpl implements TreatmentDao {

	private static Logger logger = Logger.getLogger(TreatmentDaoImpl.class);

	/**
	 * This method allows a Treatment object to be inserted into the Treatment table
	 * of the database.
	 **/
	public int insert(Treatment t) {
		logger.info("TreatmentDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int t_id = 0;

		try {
			tx = session.beginTransaction();
			t_id = (int) session.save(t);
			tx.commit();
			logger.info("Treatment object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Treatment object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return t_id;
	}

	/**
	 * This method deletes a record from the Treatment database, given a Treatment
	 * object.
	 **/
	public void delete(Treatment t) {
		logger.info("TreatmentDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(t);
			tx.commit();
			logger.info("Treatment record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Treatment object");
		} finally {
			session.close();
		}

	}

	/**
	 * This method will return a specific Treatment object that corresponds to a
	 * Treatment record in the database that matches the provided t_id
	 **/
	public Treatment returnTreatment(int t_id) {
		logger.info("TreatmentDaoImpl returnTreatment method called.");
		Treatment treatment = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			treatment = (Treatment) session.createCriteria(Treatment.class).add(Restrictions.idEq(t_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Treatment object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Treatment object returned successfully.");
		return treatment;
	}
}
