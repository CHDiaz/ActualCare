package com.actualcare.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.actualcare.beans.Admin;
import com.acutalcare.util.HibernateUtil;

public class AdminDao {
	
	//saving login and then Admin data 
	public static void insertAdmin(Admin a) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(a.getLogin());
		session.save(a);
			
		tx.commit();
		session.close();
	}
}
