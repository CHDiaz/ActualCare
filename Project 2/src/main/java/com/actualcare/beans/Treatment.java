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
 * @author Christian Diaz
 *
 */
@Entity
@Table(name="treatment")
public class Treatment {
	
	@Id
	@Column(name="t_id")
	@SequenceGenerator(sequenceName="T_SEQ", name="T_SEQ")
	@GeneratedValue(generator="T_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer t_id;
	@Column
	private String treatmentInfo;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="di_id")
//	private Diagnosis diagnosis;
	
	/**No args constructor**/
	public Treatment() {}
	
	/**All args constructor**/
	public Treatment(Integer t_id, String treatmentInfo) {
		this.t_id = t_id;
		this.treatmentInfo = treatmentInfo;
	}
	
	/**Constructor that only takes an argument for treatment for this Treatment object instance**/
	public Treatment(String treatmentInfo) {this.treatmentInfo = treatmentInfo;}
	
	/**Sets t_id for this Treatment object instance**/
	public void setT_id(Integer t_id) {this.t_id = t_id;}
	/**Sets treatmentInfo for this Treatment object instance**/
	public void setTreatmentInfo(String treatmentInfo) {this.treatmentInfo = treatmentInfo;}
	
	/**Returns the t_id for this Treatment object instance**/
	public Integer getT_id() {return t_id;}
	/**Returns the treatmentInfo for this Treatment object instance**/
	public String getTreatmentInfo() {return treatmentInfo;}
	
}
