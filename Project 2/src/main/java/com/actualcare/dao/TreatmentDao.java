package com.actualcare.dao;

import com.actualcare.beans.Treatment;

public interface TreatmentDao {

	public int insert (Treatment t);
	public void delete (Treatment t);
	public Treatment returnTreatment (int t_id);
}
