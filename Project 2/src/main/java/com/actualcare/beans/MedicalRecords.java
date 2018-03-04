package com.actualcare.beans;

import java.sql.Blob;

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
	private Blob medicalRecords;   // variable/column for attachments for MedicalRecords object instance
	@Column
	private String fileName;		// variable/column for attachments' names for MedicalRecords object instance
	
	/**All args constructor for this MedicalRecords Object Instance**/
	public MedicalRecords(Integer mr_id, Blob medicalRecords, String fileName) {
		this.mr_id = mr_id;
		this.medicalRecords = medicalRecords;
		this.fileName = fileName;
	}
	/**Constructor will all arguments except for mr_id**/
	public MedicalRecords(Blob medicalRecords, String fileName) {
		super();
		this.medicalRecords = medicalRecords;
		this.fileName = fileName;
	}
	
	/**Sets the mr_id of this MedicalRecords Object instance**/
	public void setMr_id(Integer mr_id) {this.mr_id = mr_id;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setMedicalRecords(Blob medicalRecords) {this.medicalRecords = medicalRecords;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setFileName(String fileName) {this.fileName = fileName;}
	
	/**Returns the mr_id of this MedicalRecords Object instance**/
	public Integer getMr_id() {return mr_id;}
	/**Returns a list of files of this MedicalRecords Object instance**/
	public Blob getMedicalRecords() {return medicalRecords;}
	/**Returns a list of of fileName of this MedicalRecords Object instance**/
	public String getFileName() {return fileName;}

}
