package com.actualcare.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.actualcare.beans.Treatment;
import com.actualcare.util.HibernateUtil;

public class TreatmentDaoImpl implements TreatmentDao {

	@Override
	public int insert(Treatment t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		int t_id = 0;
		
		try{
			tx = session.beginTransaction();
			t_id = (int)session.save(t);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return t_id;
	}

	@Override
	public Treatment returnTreatment(int p_id) {
		Treatment treatment = null;
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
		
			treatment = (Treatment)session.createCriteria(Treatment.class)
					.add(Restrictions.idEq(p_id)).uniqueResult();
			
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return treatment;
	}

}
