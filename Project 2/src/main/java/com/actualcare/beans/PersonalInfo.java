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
	
	
}