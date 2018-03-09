package com.actualcare.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Steven Caraballo
 *
 */
/**
 * @author Christian Diaz
 *
 */
@Entity
@Table(name="INSURANCE")
public class Insurance {
	@Id
	@Column(name="i_id")
	@SequenceGenerator(sequenceName="I_SEQ", name="I_SEQ")
	@GeneratedValue(generator="I_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer i_id;
	
	@Column
	private String i_name;

	@OneToMany(mappedBy = "myInsurance", fetch=FetchType.EAGER)
	private Set<Patient> customers;
	
	@ManyToMany(mappedBy = "insuranceList")
	private Set<Doctor> doctorList;
	
	/**No args constructor that intializes customers and doctorList to a new HashSet**/
	public Insurance() {
		this.doctorList  = new HashSet<Doctor>();
		this.customers  = new HashSet<Patient>();
		}
	/**Constructor that only sets i_name and intializes customers and doctorList to a new HashSet**/
	public Insurance(String i_name) {
		this.i_name = i_name;
		this.doctorList  = new HashSet<Doctor>();
		this.customers  = new HashSet<Patient>();
	}
	/**Args all except for Doc_id**/
	public Insurance(String i_name, Set<Patient> customers, Set<Doctor> doctorList) {
		this.i_name = i_name;
		this.customers = customers;
		this.doctorList = doctorList;
	}
	
	/**Set up args constructor**/
	public Insurance(String i_name, Set<Doctor> doctorList) {
		this.i_name = i_name;
		this.customers  = new HashSet<Patient>();
		this.doctorList = doctorList;
	}

	/**All args constructor**/
	public Insurance(Integer i_id, String i_name, Set<Patient> customers, Set<Doctor> doctorList) {
		this.i_id = i_id;
		this.i_name = i_name;
		this.customers = customers;
		this.doctorList = doctorList;
	}

	/**Sets the value of i_id**/
	public void setI_id(Integer i_id) {this.i_id = i_id;}
	/**Sets the value of i_name**/
	public void setI_name(String i_name) {this.i_name = i_name;}
	/**Sets the value of customers**/
	public void setCustomers(Set<Patient> customers) {this.customers = customers;}
	/**Sets the value of doctorList**/
	public void setDoctorList(Set<Doctor> doctorList) {this.doctorList = doctorList;}
	
	/**Return the value of i_id**/
	public Integer getI_id() {return i_id;}
	/**Return the value of i_name**/
	public String getI_name() {return i_name;}
	/**Return the value of customers**/
	public Set<Patient> getCustomers() {return customers;}
	/**Return the value of doctorList**/
	public Set<Doctor> getDoctorList() {return doctorList;}

	@Override
	public String toString() {
		return "Insurance [insurance_id=" + i_id + ", i_name=" + i_name + "]";
	}
	
	
	
}