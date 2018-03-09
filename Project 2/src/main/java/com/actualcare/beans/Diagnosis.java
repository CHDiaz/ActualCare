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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d_name == null) ? 0 : d_name.hashCode());
		result = prime * result + ((diagnosis_id == null) ? 0 : diagnosis_id.hashCode());
		result = prime * result + ((patientDiagonsis == null) ? 0 : patientDiagonsis.hashCode());
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
		Diagnosis other = (Diagnosis) obj;
		if (d_name == null) {
			if (other.d_name != null)
				return false;
		} else if (!d_name.equals(other.d_name))
			return false;
		if (diagnosis_id == null) {
			if (other.diagnosis_id != null)
				return false;
		} else if (!diagnosis_id.equals(other.diagnosis_id))
			return false;
		if (patientDiagonsis == null) {
			if (other.patientDiagonsis != null)
				return false;
		} else if (!patientDiagonsis.equals(other.patientDiagonsis))
			return false;
		return true;
	}

	
}
