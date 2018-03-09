package com.actualcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;





@Entity
@Table(name="PersonalInfo")
public class PersonalInfo {
	@Id
	@Column(name="personal_id")
	@SequenceGenerator(sequenceName="P_SEQ", name="P_SEQ")
	@GeneratedValue(generator="P_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer personal_id;
	@Column
	private String f_name;
	private String l_name;
	private Integer age;
	private String sex;
	private Integer door_no;
	private String street;
	private String city;
	private String state;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="P_Id")
	private Patient patient;
	
	public PersonalInfo() {
		super();
		
	}
	
	public PersonalInfo(Integer personal_id, String f_name, String l_name, Integer age, String sex, Integer door_no,
			String street, String city, String state) {
		super();
		this.personal_id = personal_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.age = age;
		this.sex = sex;
		this.door_no = door_no;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	
	public PersonalInfo(String f_name, String l_name, Integer age, String sex, Integer door_no,
			String street, String city, String state) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.age = age;
		this.sex = sex;
		this.door_no = door_no;
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public Integer getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(Integer personal_id) {
		this.personal_id = personal_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getDoor_no() {
		return door_no;
	}

	public void setDoor_no(Integer door_no) {
		this.door_no = door_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

		
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "PersonalInfo [personal_id=" + personal_id + ", f_name=" + f_name + ", l_name=" + l_name + ", age=" + age
				+ ", sex=" + sex + ", door_no=" + door_no + ", street=" + street + ", city=" + city + ", state=" + state
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((door_no == null) ? 0 : door_no.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((personal_id == null) ? 0 : personal_id.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		PersonalInfo other = (PersonalInfo) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (door_no == null) {
			if (other.door_no != null)
				return false;
		} else if (!door_no.equals(other.door_no))
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (l_name == null) {
			if (other.l_name != null)
				return false;
		} else if (!l_name.equals(other.l_name))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (personal_id == null) {
			if (other.personal_id != null)
				return false;
		} else if (!personal_id.equals(other.personal_id))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
}