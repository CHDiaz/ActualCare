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
@Table(name="Insurance")
public class Insurance {
	@Id
	@Column(name="insurance_id")
	@SequenceGenerator(sequenceName="I_SEQ", name="I_SEQ")
	@GeneratedValue(generator="I_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer insurance_id;
	
	@Column
	private String i_name;

	
	
	@OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="P_Id")
		private Patient patient;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="D_Id")
	private Doctor doctor;
	
	public Insurance() {
		super();
	}
	
	public Insurance(Integer insurance_id, String i_name) {
		super();
		this.insurance_id = insurance_id;
		this.i_name = i_name;
	}
	
	public Insurance(String i_name) {
		super();
		this.i_name = i_name;
	}

	public Integer getInsurance_id() {
		return insurance_id;
	}

	public void setInsurance_id(Integer insurance_id) {
		this.insurance_id = insurance_id;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Insurance [insurance_id=" + insurance_id + ", i_name=" + i_name + "]";
	}
	
	
	
}