package com.actualcare.dao;

import java.util.List;

import com.actualcare.beans.Treatment;

/**
 * @author Christian Diaz
 *
 */
public interface TreatmentDao {
	/**
	 * This method allows a Treatment object to be inserted into the Treatment table
	 * of the database.
	 **/
	public int insert(Treatment t);

	/**
	 * This method deletes a record from the Treatment database, given a Treatment
	 * object.
	 **/
	public void delete(Treatment t);

	/**
	 * This method will return a specific Treatment object that corresponds to a
	 * Treatment record in the database that matches the provided t_id
	 **/
	public Treatment returnTreatment(int t_id);
	/**Method to return all of the treatments in the database as a list of Treatments.**/
	public List<Treatment> returnAllTreatments();
}
