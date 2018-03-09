package com.actualcare.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Diagnosis")
public class Diagnosis {
	@Id
	@Column(name="diagnosis_id")
	@SequenceGenerator(sequenceName="D_SEQ", name="D_SEQ")
	@GeneratedValue(generator="D_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer diagnosis_id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_Diagonsis")
	private Patient patientDiagonsis;
	
	@Column
	private String d_name;

	public Integer getDiagnosis_id() {
		return diagnosis_id;
	}

	public void setDiagnosis_id(Integer diagnosis_id) {
		this.diagnosis_id = diagnosis_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	
	



	public void setPatientDiagonsis(Patient patientDiagonsis) {
		this.patientDiagonsis = patientDiagonsis;
	}

	public Diagnosis(Integer diagnosis_id, String d_name) {
		super();
		this.diagnosis_id = diagnosis_id;
		this.d_name = d_name;
	}

	public Diagnosis(String d_name) {
		super();
		this.d_name = d_name;
	}
	
	public Diagnosis() {
		super();
	}
	
	@Override
	public String toString() {
		return "Diagnosis [diagnosis_id=" + diagnosis_id + ", d_name=" + d_name + "]";
	}

	
}
