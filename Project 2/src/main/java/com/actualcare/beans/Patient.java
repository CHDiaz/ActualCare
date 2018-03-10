package com.actualcare.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Patient")
public class Patient {
	
	@Id
	@Column(name="p_id")
	@SequenceGenerator(sequenceName="PATIENT_SEQ", name="PATIENT_SEQ")
	@GeneratedValue(generator="PATIENT_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer p_id;
		
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="a_id") 
	private Allergy myAllgeries;
	
	@OneToMany(mappedBy = "patientAppointments", fetch=FetchType.EAGER)
	private Set<Appointments> myAppointments;
	
	@OneToMany(mappedBy = "patientDiagonsis", fetch=FetchType.EAGER)
	private Set<Diagnosis> medicalHistory;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_Insurance")
	private Insurance myInsurance;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_Doctor")
	private Doctor PCP;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Login_id")
	private LoginInfo login;
	
	@OneToMany(mappedBy = "patientMedicalRecords", fetch=FetchType.EAGER)
	private Set<MedicalRecords> medicalTests;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personal_id") 
	private PersonalInfo myPersonalInfo ;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="sympton_id") 
	private Sympton mySymptons;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="t_id") 
	private Treatment myMedications;
	
	/**No args constructor**/
	public Patient() {
		this.myAppointments = new HashSet<Appointments>();
		this.medicalHistory = new HashSet<Diagnosis>();
		this.medicalTests = new HashSet<MedicalRecords>();
	}

	/**Only login info constructor**/
	public Patient(LoginInfo login) {
		this.myAppointments = new HashSet<Appointments>();
		this.medicalHistory = new HashSet<Diagnosis>();
		this.medicalTests = new HashSet<MedicalRecords>();
		this.login = login;}

	/**Set less all args constructor**/
	public Patient(Insurance myInsurance, LoginInfo login,PersonalInfo myPersonalInfo) {
		this.myAppointments = new HashSet<Appointments>();
		this.medicalHistory = new HashSet<Diagnosis>();
		this.medicalTests = new HashSet<MedicalRecords>();
		this.myInsurance = myInsurance;
		this.login = login;
		this.myPersonalInfo = myPersonalInfo;
	}
	
	/**Set less all args constructor**/
	public Patient( Allergy myAllgeries, Insurance myInsurance, LoginInfo login,
			PersonalInfo myPersonalInfo, Sympton mySymptons, Treatment myMedications) {
		this.myAppointments = new HashSet<Appointments>();
		this.medicalHistory = new HashSet<Diagnosis>();
		this.medicalTests = new HashSet<MedicalRecords>();
		this.myAllgeries = myAllgeries;
		this.myInsurance = myInsurance;
		this.login = login;
		this.myPersonalInfo = myPersonalInfo;
		this.mySymptons = mySymptons;
		this.myMedications = myMedications;
	}

	/**Except p_id, all args constructor**/
	public Patient(Allergy myAllgeries, Set<Appointments> myAppointments, Set<Diagnosis> medicalHistory,
			Insurance myInsurance, LoginInfo login, Set<MedicalRecords> medicalTests, PersonalInfo myPersonalInfo,
			Sympton mySymptons, Treatment myMedications) {
		this.myAllgeries = myAllgeries;
		this.myAppointments = myAppointments;
		this.medicalHistory = medicalHistory;
		this.myInsurance = myInsurance;
		this.login = login;
		this.medicalTests = medicalTests;
		this.myPersonalInfo = myPersonalInfo;
		this.mySymptons = mySymptons;
		this.myMedications = myMedications;
	}

	/**All args constructor**/
	public Patient(Integer p_id, Allergy myAllgeries, Set<Appointments> myAppointments, Set<Diagnosis> medicalHistory,
			Insurance myInsurance, LoginInfo login, Set<MedicalRecords> medicalTests, PersonalInfo myPersonalInfo,
			Sympton mySymptons, Treatment myMedications, Doctor PCP) {
		this.p_id = p_id;
		this.myAllgeries = myAllgeries;
		this.myAppointments = myAppointments;
		this.medicalHistory = medicalHistory;
		this.myInsurance = myInsurance;
		this.login = login;
		this.medicalTests = medicalTests;
		this.myPersonalInfo = myPersonalInfo;
		this.mySymptons = mySymptons;
		this.myMedications = myMedications;
		this.PCP = PCP;
	}

	/**Sets the value of p_id**/
	public void setP_id(Integer p_id) {this.p_id = p_id;}
	/**Sets the value of myAllgeries**/
	public void setMyAllgeries(Allergy myAllgeries) {this.myAllgeries = myAllgeries;}
	/**Sets the value of myAppointments**/
	public void setMyAppointments(Set<Appointments> myAppointments) {this.myAppointments = myAppointments;}
	/**Sets the value of medicalHistory**/
	public void setMedicalHistory(Set<Diagnosis> medicalHistory) {this.medicalHistory = medicalHistory;}
	/**Sets the value of myInsurance**/
	public void setMyInsurance(Insurance myInsurance) {this.myInsurance = myInsurance;}
	/**Sets the value of login**/
	public void setLogin(LoginInfo login) {this.login = login;}
	/**Sets the value of medicaTests**/
	public void setMedicalTests(Set<MedicalRecords> medicalTests) {this.medicalTests = medicalTests;}
	/**Sets the value of myPersonalInfo**/
	public void setMyPersonalInfo(PersonalInfo myPersonalInfo) {this.myPersonalInfo = myPersonalInfo;}
	/**Sets the value of mySymptons**/
	public void setMySymptons(Sympton mySymptons) {this.mySymptons = mySymptons;}
	/**Sets the value of myMedications**/
	public void setMyMedications(Treatment myMedications) {this.myMedications = myMedications;}

	/**Returns the value of p_id**/
	public Integer getP_id() {return p_id;}
	/**Returns the value of myAllgeries**/
	public Allergy getMyAllgeries() {return myAllgeries;}
	/**Returns the value of myAppointments**/
	public Set<Appointments> getMyAppointments() {return myAppointments;}
	/**Returns the value of medicalHistory**/
	public Set<Diagnosis> getMedicalHistory() {return medicalHistory;}
	/**Returns the value of myInsurance**/
	public Insurance getMyInsurance() {return myInsurance;}
	/**Returns the value of login**/
	public LoginInfo getLogin() {return login;}
	/**Returns the value of medicalTests**/
	public Set<MedicalRecords> getMedicalTests() {return medicalTests;}
	/**Returns the value of myPersonalInfo**/
	public PersonalInfo getMyPersonalInfo() {return myPersonalInfo;}
	/**Returns the value of mySymptons**/
	public Sympton getMySymptons() {return mySymptons;}
	/**Returns the value of mymedications**/
	public Treatment getMyMedications() {return myMedications;}

	
}