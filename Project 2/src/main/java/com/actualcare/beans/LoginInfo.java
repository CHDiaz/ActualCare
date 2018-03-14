package com.actualcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * this table has login info for all roles
 * mapping to roles are done in their own table
 * @author haris
 *
 */

@Entity
@Table(name="LoginInfo")
public class LoginInfo {
	
	//Login ID
	@Id
	@Column(name="Login_id")
	@SequenceGenerator(sequenceName="LOGIN_SEQ", name="LOGIN_SEQ")
	@GeneratedValue(generator="LOGIN_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer Login_id;
	
	//role email
	@Column
	private String email;
	
	//role password
	@Column
	private String password;
	
	@Column
	private String role;
	
	//Constructor with ID
	public LoginInfo(Integer login_id, String email, String password, String role) {
		super();
		Login_id = login_id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	//Constructor without ID
	public LoginInfo(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	//Empty Constructor
	public LoginInfo() {
		super();
	}
	
	//Getters & Setters
	public Integer getLogin_id() {
		return Login_id;
	}

	public void setLogin_id(Integer login_id) {
		Login_id = login_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getrole() {
		return role;
	}

	public void setrole(String role) {
		this.role = role;
	}
		
}
