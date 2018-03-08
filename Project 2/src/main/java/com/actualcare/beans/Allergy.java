package com.actualcare.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Allergy")
public class Allergy {
	@Id
	@Column(name="allergy_id")
	@SequenceGenerator(sequenceName="A_SEQ", name="A_SEQ")
	@GeneratedValue(generator="A_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer allergy_id;
	
	@Column
	private String a_name;

	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="P_Id")
		private Patient patient;



	public Integer getAllergy_id() {
		return allergy_id;
	}



	public void setAllergy_id(Integer allergy_id) {
		this.allergy_id = allergy_id;
	}



	public String getA_name() {
		return a_name;
	}



	public void setA_name(String a_name) {
		this.a_name = a_name;
	}



	public Allergy(Integer allergy_id, String a_name) {
		super();
		this.allergy_id = allergy_id;
		this.a_name = a_name;
	}
	
	public Allergy(String a_name) {
		super();
		this.a_name = a_name;
	}

	
	
	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Allergy() {
		super();
	}



	@Override
	public String toString() {
		return "Allergy [allergy_id=" + allergy_id + ", a_name=" + a_name + ", patient=" + patient + "]";
	}
	
	
}
