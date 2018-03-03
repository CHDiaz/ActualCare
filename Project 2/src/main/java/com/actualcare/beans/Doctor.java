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

/**
 * Bean is incomplete
 * Add as much feature to it
 * @author haris
 *
 */

@Entity
@Table(name="Doctor")
public class Doctor {
	
	//Doctor Id
	@Id
	@Column
	@SequenceGenerator(sequenceName="DOCTOR_SEQ", name="DOCTOR_SEQ")
	@GeneratedValue(generator="DOCTOR_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer D_Id;
	
	//One to One relation with LoginInfo table
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Login_id")
	private LoginInfo login;
	
	//Empty Constructor
	public Doctor() {
		super();
	}
	
	//Constructor with Id
	public Doctor(Integer d_Id, LoginInfo login) {
		super();
		D_Id = d_Id;
		this.login = login;
	}
	
	//Constructor without Id
	public Doctor(LoginInfo login) {
		super();
		this.login = login;
	}
	
	//Getters & Setters
	public Integer getD_Id() {
		return D_Id;
	}

	public void setD_Id(Integer d_Id) {
		D_Id = d_Id;
	}

	public LoginInfo getLogin() {
		return login;
	}

	public void setLogin(LoginInfo login) {
		this.login = login;
	}
	
}
