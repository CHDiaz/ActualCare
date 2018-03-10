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
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "Patient_Doctor",
			joinColumns = { @JoinColumn(name = "p_id") },
			inverseJoinColumns = { @JoinColumn(name = "doc_id") })
	private Set<Patient> myPatients;
	
	@OneToMany(mappedBy = "doctorAppointments", fetch=FetchType.EAGER)
	private Set<Appointments> myAppointments;
	
	/**No args constructor**/
	public Doctor() { }
	
	/**constructor without Doc_id field, login field, Insurance field**/
	public Doctor(String name) {
		super();
		this.name = name;
		this.myPatients  = new HashSet<Patient>();
	}

	
	/**constructor without Doc_id field, Insurance field**/
	public Doctor(String name, LoginInfo login) {
		super();
		this.name = name;
		this.login = login;
		this.myPatients  = new HashSet<Patient>();
	}

	/**All agrs constructor**/
	public Doctor(Integer doc_id, String name, LoginInfo login, Set<Patient> myPatients,
			Set<Appointments> myAppointments) {
		super();
		Doc_id = doc_id;
		this.name = name;
		this.login = login;
		this.myPatients = myPatients;
		this.myAppointments = myAppointments;
	}

	/**Sets the value of D_id for this Doctor Object**/
	public void setD_Id(Integer Doc_id) {this.Doc_id = Doc_id;}
	/**Sets the value of name for this Doctor Object**/
	public String getName() {return name;}
	/**Sets the value of login for this Doctor Object**/
	public void setLogin(LoginInfo login) {this.login = login;}
	
	/**Returns the value of Doc_id**/
	public Integer getDoc_Id() {return Doc_id;}
	/**Returns the value of name**/
	public void setName(String name) {this.name = name;}
	/**Returns the value of login**/
	public LoginInfo getLogin() {return login;}
	
	public void addPatient(Patient p) {
		myPatients.add(p);
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Doc_id == null) ? 0 : Doc_id.hashCode());
		result = prime * result + ((insuranceList == null) ? 0 : insuranceList.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((myAppointments == null) ? 0 : myAppointments.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (Doc_id == null) {
			if (other.Doc_id != null)
				return false;
		} else if (!Doc_id.equals(other.Doc_id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (myAppointments == null) {
			if (other.myAppointments != null)
				return false;
		} else if (!myAppointments.equals(other.myAppointments))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

/*	@Override
	public String toString() {
		return "Doctor [Doc_id=" + Doc_id + ", name=" + name + ", login=" + login + ", insuranceList=" + insuranceList
				+ ", myAppointments=" + myAppointments + "]";
	}
*/
	
	
}