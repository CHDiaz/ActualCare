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
@Table(name="Patient")
public class Patient {
	
	//Patient Id
	@Id
	@Column
	@SequenceGenerator(sequenceName="PATIENT_SEQ", name="PATIENT_SEQ")
	@GeneratedValue(generator="PATIENT_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer P_Id;
	
	//One to One relation with LoginInfo table
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Login_id")
	private LoginInfo login;

	//Empty Constructor
	public Patient() {
		super();
	}
	
	//Constructor with Id
	public Patient(Integer p_Id, LoginInfo login) {
		super();
		P_Id = p_Id;
		this.login = login;
	}
	
	//Constructor without Id
	public Patient(LoginInfo login) {
		super();
		this.login = login;
	}
	
	
	//Getters & Setters
	public Integer getP_Id() {
		return P_Id;
	}

	public void setP_Id(Integer p_Id) {
		P_Id = p_Id;
	}

	public LoginInfo getLogin() {
		return login;
	}

	public void setLogin(LoginInfo login) {
		this.login = login;
	}
	
	
}