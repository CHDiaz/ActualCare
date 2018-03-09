package com.actualcare.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Appointments;
import com.actualcare.util.HibernateUtil;

public class AppointmentsDaoImpl implements AppointmentsDao{

	private static Logger logger = Logger.getLogger(AppointmentsDaoImpl.class);

	public int insert(Appointments a) {
		logger.info("AppointmentsDaoImpl insert method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int app_id = 0;

		try {
			tx = session.beginTransaction();
			app_id = (int) session.save(a);
			tx.commit();
			logger.info("Appointments object inserted successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.error("Appointments object was NOT inserted");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return app_id;
	}

	public void delete(Appointments a) {
		logger.info("AppointmentsDaoImpl delete method called.");

		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(a);
			tx.commit();
			logger.info("Appointments record deleted successfully");

		} catch (HibernateException e) {
			e.printStackTrace();
			logger.info("Delete method was NOT able to delete Appointments object");
		} finally {
			session.close();
		}
	}
		
	public Appointments returnAppointments(int app_id) {
		logger.info("AppointmentsDaoImpl returnSympton method called.");
		Appointments appointments = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			appointments = (Appointments) session.createCriteria(Appointments.class).add(Restrictions.idEq(app_id)).uniqueResult();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				logger.info("Appointments object/record NOT found");
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Appointments object returned successfully.");
		return appointments;
	}

	
	
	
	
}
