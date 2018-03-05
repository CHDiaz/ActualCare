package com.actualcare.dao;

import java.io.File;
import java.sql.Blob;

import com.actualcare.beans.MedicalRecords;

/**
 * @author Christian Diaz
 *
 */
public interface MedicalRecordsDao {
	/**
	 * Method for inserting a record into the MedicalRecords table, based on the
	 * provided MedicalRecords object.q
	 **/
	public int insert(MedicalRecords m);
	/**
	 * Method that deletes a MedicalRecords record from the database that matches
	 * the provided MedicalRecords object.
	 **/
	public void delete(MedicalRecords m);
	/**
	 * Method for search through the MedicalRecords table for a specific m_id and
	 * returning the record as an object if it exists.
	 **/
	public MedicalRecords returnMedicalRecords(int m_id);
	/**
	 * Method that will take a MedicalRecords Blob object and convert it into a file
	 * that will be returned back to the user.
	 **/
	public File convertToFile(MedicalRecords m);
	/** Method that returns a file associated with a m_id **/
	public File getFile(int m_id);
}
