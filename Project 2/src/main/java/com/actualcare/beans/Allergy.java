package com.actualcare.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Allergy")
public class Allergy {
	@Id
	@Column(name="a_id")
	@SequenceGenerator(sequenceName="A_SEQ", name="A_SEQ")
	@GeneratedValue(generator="A_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer a_id;
	
	@Column(name="allergyInfo")
	private String a_name;



	public Integer getA_id() {
		return a_id;
	}



	public void setAllergy_id(Integer a_id) {
		this.a_id = a_id;
	}



	public String getA_name() {
		return a_name;
	}



	public void setA_name(String a_name) {
		this.a_name = a_name;
	}



	public Allergy(Integer a_id, String a_name) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
	}
	
	public Allergy(String a_name) {
		super();
		this.a_name = a_name;
	}

	public Allergy() {
		super();
	}



	@Override
	public String toString() {
		return "Allergy [a_id=" + a_id + ", a_name=" + a_name + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a_id == null) ? 0 : a_id.hashCode());
		result = prime * result + ((a_name == null) ? 0 : a_name.hashCode());
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
		Allergy other = (Allergy) obj;
		if (a_id == null) {
			if (other.a_id != null)
				return false;
		} else if (!a_id.equals(other.a_id))
			return false;
		if (a_name == null) {
			if (other.a_name != null)
				return false;
		} else if (!a_name.equals(other.a_name))
			return false;
		return true;
	}
	
	
}
