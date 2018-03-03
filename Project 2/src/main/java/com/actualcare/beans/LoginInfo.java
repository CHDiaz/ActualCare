package com.actualcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * this table has login info for all users
 * mapping to users are done in their own table
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
	
	//User email
	@Column
	private String email;
	
	//User password
	@Column
	private String password;
	
	//Constructor with ID
	public LoginInfo(Integer login_id, String email, String password) {
		super();
		Login_id = login_id;
		this.email = email;
		this.password = password;
	}
	
	//Constructor without ID
	public LoginInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "LoginInfo [Login_id=" + Login_id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Login_id == null) ? 0 : Login_id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		return true;
	}
	
}
