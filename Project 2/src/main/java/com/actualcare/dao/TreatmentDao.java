package com.actualcare.dao;

import com.actualcare.beans.Treatment;

public interface TreatmentDao {

	public int insert (Treatment t);
	public Treatment returnTreatment (int p_id);
}
