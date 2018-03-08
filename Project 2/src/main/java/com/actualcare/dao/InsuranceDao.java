package com.actualcare.dao;

import com.actualcare.beans.Insurance;
public interface InsuranceDao {

	
	public int insert(Insurance i);

	public void delete(Insurance i);
	
	public Insurance returnInsurance(int insurance_id);

}

