package com.actualcare.beans;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private byte[] medicalRecords;   // variable/column for attachments for MedicalRecords object instance
	@Column
	private String fileName;		// variable/column for attachments' names for MedicalRecords object instance
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_MedicalRecords")
	private Patient patientMedicalRecords;
	
	/**No args constructor for creating empty objects**/
	public MedicalRecords() {}
	
	/**All args constructor for this MedicalRecords Object Instance**/
	public MedicalRecords(Integer mr_id, byte[] medicalRecords, String fileName) {
		this.mr_id = mr_id;
		this.medicalRecords = medicalRecords;
		this.fileName = fileName;
	}
	/**Constructor will all arguments except for mr_id**/
	public MedicalRecords(byte[] medicalRecords, String fileName) {
		super();
		this.medicalRecords = medicalRecords;
		this.fileName = fileName;
	}
	
	/**Sets the mr_id of this MedicalRecords Object instance**/
	public void setMr_id(Integer mr_id) {this.mr_id = mr_id;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setMedicalRecords(byte[] medicalRecords) {this.medicalRecords = medicalRecords;}
	/**Sets the fileName of this MedicalRecords Object instance**/
	public void setFileName(String fileName) {this.fileName = fileName;}
	
	/**Returns the mr_id of this MedicalRecords Object instance**/
	public Integer getMr_id() {return mr_id;}
	/**Returns a list of files of this MedicalRecords Object instance**/
	public byte[] getMedicalRecords() {return medicalRecords;}
	/**Returns a list of of fileName of this MedicalRecords Object instance**/
	public String getFileName() {return fileName;}

	@Override
	public String toString() {
		return "MedicalRecords [mr_id=" + mr_id + ", medicalRecords=" + Arrays.toString(medicalRecords) + ", fileName="
				+ fileName + ", patientMedicalRecords=" + patientMedicalRecords + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + Arrays.hashCode(medicalRecords);
		result = prime * result + ((mr_id == null) ? 0 : mr_id.hashCode());
		result = prime * result + ((patientMedicalRecords == null) ? 0 : patientMedicalRecords.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalRecords other = (MedicalRecords) obj;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (!Arrays.equals(medicalRecords, other.medicalRecords))
			return false;
		if (mr_id == null) {
			if (other.mr_id != null)
				return false;
		} else if (!mr_id.equals(other.mr_id))
			return false;
		if (patientMedicalRecords == null) {
			if (other.patientMedicalRecords != null)
				return false;
		} else if (!patientMedicalRecords.equals(other.patientMedicalRecords))
			return false;
		return true;
	}
	
	
}
