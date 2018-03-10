package com.actualcare.dao;

import java.util.List;

import com.actualcare.beans.Patient;

/**
 * @author Harish Kumar Chandra
 *
 */

/**
 * @author Christian Diaz
 *
 */
public interface PatientDao {
	
	/**
	 * Method for inserting a record into the Patients table, based on the
	 * provided Patient object.
	 **/
	public int insert(Patient p);
	/**
	 * Method for inserting a record after registering into the Patients table, based on the
	 * provided Patient object.
	 **/
	public int insertRegister(Patient p);
	public void updateAllergy(Patient p, String allergy);
	public void updateSympton(Patient p, String sympton);
	/**
	 * Method for deleting a record from the Patients table, based on the
	 * provided Patient object.
	 **/
	public void delete(Patient p);
	/**
	 * Method for returning a record from the Patients table as a Patient object, 
	 * based on the provided Patient id.
	 **/
	public Patient returnPatient(int p_id);
	public Patient returnPatientByLoginId(int l_id);
	/**
	 * Method for returning all records from the Patients table as a list of Patients.
	 **/
	public List<Patient> returnAllPatients();
	
}