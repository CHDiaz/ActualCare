package com.actualcare.dao;

import java.util.List;

import com.actualcare.beans.Insurance;

/**
 * @author Steven Caraballo
 *
 */
/**
 * @author Christian Diaz
 *
 */
public interface InsuranceDao {
	/**
	 * Method that inserts an Insurance record into the Insurance table, based on
	 * the specificed Insurance object.
	 **/
	public int insert(Insurance i);

	/**
	 * Method that deletes an Insurance record from the Insurance table, based on
	 * the specificed Insurance object.
	 **/
	public void delete(Insurance i);

	/**
	 * Method that returns an Insurance record from the Insurance table, based on
	 * the specificed Insurance i_id.
	 **/
	public Insurance returnInsurance(int insurance_id);
  
	/** Method that returns all Insurance records from the Insurance table. **/
	public List<Insurance> returnAllInsurance();
	
	public Insurance returnInsuranceByName(String i_name);

	

}
