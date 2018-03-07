package com.actualcare.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.actualcare.beans.LoginInfo;
import com.actualcare.util.HibernateUtil;


public class LoginInfoDao {
	
	public static List<LoginInfo> getAllLogin(){
		List<LoginInfo> logins = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			logins = session.createQuery("FROM LOGININFO").list();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return logins;
	}
	
}
