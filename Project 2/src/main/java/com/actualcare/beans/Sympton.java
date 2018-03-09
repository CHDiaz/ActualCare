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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patientSympton == null) ? 0 : patientSympton.hashCode());
		result = prime * result + ((s_name == null) ? 0 : s_name.hashCode());
		result = prime * result + ((sympton_id == null) ? 0 : sympton_id.hashCode());
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
		Sympton other = (Sympton) obj;
		if (patientSympton == null) {
			if (other.patientSympton != null)
				return false;
		} else if (!patientSympton.equals(other.patientSympton))
			return false;
		if (s_name == null) {
			if (other.s_name != null)
				return false;
		} else if (!s_name.equals(other.s_name))
			return false;
		if (sympton_id == null) {
			if (other.sympton_id != null)
				return false;
		} else if (!sympton_id.equals(other.sympton_id))
			return false;
		return true;
	}
	
	
}
