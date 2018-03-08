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

	@Override
	public String toString() {
		return "LoginInfo [Login_id=" + Login_id + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Login_id == null) ? 0 : Login_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		LoginInfo other = (LoginInfo) obj;
		if (Login_id == null) {
			if (other.Login_id != null)
				return false;
		} else if (!Login_id.equals(other.Login_id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	

		
}
