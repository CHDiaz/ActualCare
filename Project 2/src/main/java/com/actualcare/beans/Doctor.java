package com.actualcare.beans;

import java.util.HashSet;
import java.util.Set;
import com.actualcare.beans.Insurance;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Harish Kumar Chandra
 *
 */
/**
 * @author Christian Diaz
 *
 */
@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Id
	@Column
	@SequenceGenerator(sequenceName="DOCTOR_SEQ", name="DOCTOR_SEQ")
	@GeneratedValue(generator="DOCTOR_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer Doc_id;
	
	@Column
	private String name;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Login_id")
	private LoginInfo login;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(
			name = "Doctor_Insurance",
			joinColumns = { @JoinColumn(name = "Doc_id") },
			inverseJoinColumns = { @JoinColumn(name = "i_id") })
	private Set<Insurance> insuranceList;
	
	@OneToMany(mappedBy = "doctorAppointments", fetch=FetchType.EAGER)
	private Set<Appointments> myAppointments;
	
	/**No args constructor**/
	public Doctor() { this.insuranceList  = new HashSet<Insurance>();}
	
	/**constructor without Doc_id field, Insurance field**/
	public Doctor(String name, LoginInfo login) {
		super();
		this.name = name;
		this.login = login;
		this.insuranceList  = new HashSet<Insurance>();
	}

	/**constructor without Doc_id field**/
	public Doctor(String name, LoginInfo login, Set<Insurance> insuranceList) {
		super();
		this.name = name;
		this.login = login;
		this.insuranceList = insuranceList;
	}

	/**All agrs constructor**/
	public Doctor(Integer doc_id, String name, LoginInfo login, Set<Insurance> insuranceList) {
		super();
		Doc_id = doc_id;
		this.name = name;
		this.login = login;
		this.insuranceList = insuranceList;
	}

	/**Sets the value of D_id for this Doctor Object**/
	public void setD_Id(Integer Doc_id) {this.Doc_id = Doc_id;}
	/**Sets the value of name for this Doctor Object**/
	public String getName() {return name;}
	/**Sets the value of login for this Doctor Object**/
	public void setLogin(LoginInfo login) {this.login = login;}
	/**Sets the value of the set insuranceList for this Doctor Object**/
	public void setInsuranceList(Set<Insurance> insuranceList) {this.insuranceList = insuranceList;}
	
	/**Returns the value of Doc_id**/
	public Integer getDoc_Id() {return Doc_id;}
	/**Returns the value of name**/
	public void setName(String name) {this.name = name;}
	/**Returns the value of login**/
	public LoginInfo getLogin() {return login;}
	/**Returns the value of the set of insuranceList**/
	public Set<Insurance> getInsuranceList() {
		return insuranceList;
	}
	
	public void addInsurance(Insurance i) {
		insuranceList.add(i);
	}

	
	
}