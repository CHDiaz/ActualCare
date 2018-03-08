package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.PersonalInfo;
import com.actualcare.util.HibernateUtil;

public class PersonalInfoDaoImpl implements PersonalInfoDao {
private static Logger logger = Logger.getLogger(PersonalInfoDaoImpl.class);

	
	public int insert(PersonalInfo pi) {
		logger.info("PersonalInfoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int personal_id = 0;

		try {
			tx = session.beginTransaction();
			personal_id = (int) session.save(pi);
			tx.commit();
			logger.info("PersonalInfo object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("PersonalInfo object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personal_id;
	}

	
	public void delete(PersonalInfo pi) {
		logger.info("PersonalInfoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(pi);
			tx.commit();
			logger.info("Insurance record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Insurance object");
		} finally {
			session.close();
		}

	}

	
	public PersonalInfo returnPersonalInfo(int personal_id) {
		logger.info("PersonalInfoImpl returnTreatment method called.");
		PersonalInfo personal = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			personal = (PersonalInfo) session.createCriteria(PersonalInfo.class).add(Restrictions.idEq(personal_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("PersonalInfo object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Insurance object returned successfully.");
		return personal;
	}
	
	public PersonalInfo getPersonalInfoByPatId(Integer patient){
		PersonalInfo personalInfo = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			System.out.println("Grabbing the object for the first time...");
			personalInfo = (PersonalInfo)session.get(PersonalInfo.class, patient);
			
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return personalInfo;
}
}
