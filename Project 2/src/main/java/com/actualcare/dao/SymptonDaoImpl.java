package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Sympton;
import com.actualcare.util.HibernateUtil;

public class SymptonDaoImpl implements SymptonDao {
	private static Logger logger = Logger.getLogger(SymptonDaoImpl.class);

	public int insert(Sympton s) {
		logger.info("SymptonDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int sympton_id = 0;

		try {
			tx = session.beginTransaction();
			sympton_id = (int) session.save(s);
			tx.commit();
			logger.info("Sympton object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Sympton object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return sympton_id;
	}

	public void delete(Sympton s) {
		logger.info("SymptonDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(s);
			tx.commit();
			logger.info("Sympton record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Sympton object");
		} finally {
			session.close();
		}
	}
		
	public Sympton returnSympton(int sympton_id) {
		logger.info("SymptonDaoImpl returnSympton method called.");
		Sympton sympton = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			sympton = (Sympton) session.createCriteria(Sympton.class).add(Restrictions.idEq(sympton_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Sympton object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Sympton object returned successfully.");
		return sympton;
	}	
	
	public Sympton getSymptonByPatId(Integer patient){
			Sympton sympton = null;
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				
				tx = session.beginTransaction();
				System.out.println("Grabbing the object for the first time...");
				sympton = (Sympton)session.get(Sympton.class, patient);
				
				
			}catch(HibernateException e){
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}finally{
				session.close();
			}
			return sympton;
	}
}
