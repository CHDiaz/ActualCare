package com.actualcare.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.actualcare.beans.Patient;
import com.actualcare.util.HibernateUtil;

/**
 * This Patient is incomplete
 * Add as much feature to it
 * @author haris
 *
 */
public class PatientDao {
	
	//saving login and then patient data 
	public static void insertPatient(Patient p) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(p.getLogin());
		session.save(p);
		
		tx.commit();
		session.close();
	}
}