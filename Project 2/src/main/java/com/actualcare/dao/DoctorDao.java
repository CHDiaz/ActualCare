package com.actualcare.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.actualcare.beans.Doctor;
import com.acutalcare.util.HibernateUtil;

public class DoctorDao {
	
	//saving login and then doctor data 
	public static void insertDoctor(Doctor d) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(d.getLogin());
		session.save(d);
			
		tx.commit();
		session.close();
	}
	
}
