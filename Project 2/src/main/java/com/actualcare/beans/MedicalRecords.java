package com.actualcare.beans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Christian Diaz
 *
 */
@Entity
@Table(name="medical_records")
public class MedicalRecords {
	@Id
	@Column(name="mr_id")
	@SequenceGenerator(sequenceName="MR_SEQ", name="MR_SEQ")
	@GeneratedValue(generator="MR_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer mr_id; 				 // variable/column for unique identifier for MedicalRecords object instance
	@Column
	private List<File> medicalRecords;   // variable/column for attachments for MedicalRecords object instance
	@Column
	private List<String> fileNames;		// variable/column for attachments' names for MedicalRecords object instance
	
	/**All args constructor for this MedicalRecords Object Instance**/
	public MedicalRecords(Integer mr_id, List<File> medicalRecords, List<String> fileNames) {
		this.mr_id = mr_id;
		this.medicalRecords = medicalRecords;
		this.fileNames = fileNames;
	}
	/**No args constructor to initialize both list to a new ArrayList of their respective types.**/
	public MedicalRecords() {
		this.medicalRecords = new ArrayList<File>();
		this.fileNames = new ArrayList<String>();
	}
	
	/**Sets the mr_id of this MedicalRecords Object instance**/
	public void setMr_id(Integer mr_id) {this.mr_id = mr_id;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setMedicalRecords(List<File> medicalRecords) {this.medicalRecords = medicalRecords;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setFileName(List<String> fileNames) {this.fileNames = fileNames;}
	
	/**Returns the mr_id of this MedicalRecords Object instance**/
	public Integer getMr_id() {return mr_id;}
	/**Returns a list of files of this MedicalRecords Object instance**/
	public List<File> getMedicalRecords() {return medicalRecords;}
	/**Returns a list of of fileName of this MedicalRecords Object instance**/
	public List<String> getFileNames() {return fileNames;}

}
