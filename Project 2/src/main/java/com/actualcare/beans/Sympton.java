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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Symptoms")
public class Sympton {
	@Id
	@Column(name="sympton_id")
	@SequenceGenerator(sequenceName="S_SEQ", name="S_SEQ")
	@GeneratedValue(generator="S_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer sympton_id;
	
	@Column
	private String s_name;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_Sympton")
	private Patient patientSympton;


	public Integer getSympton_id() {
		return sympton_id;
	}



	public void setSympton_id(Integer sympton_id) {
		this.sympton_id = sympton_id;
	}



	public String getS_name() {
		return s_name;
	}



	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public Sympton(Integer sympton_id, String s_name) {
		super();
		this.sympton_id = sympton_id;
		this.s_name = s_name;
	}

	public Sympton(String s_name) {
		super();
		this.s_name = s_name;
	}
	
	public Sympton() {
		super();
	}



	@Override
	public String toString() {
		return "Sympton [sympton_id=" + sympton_id + ", s_name=" + s_name + ", patient=" + "]";
	}
	
	
}
