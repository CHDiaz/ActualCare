package com.actualcare.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Christian Diaz
 *
 */
@Entity
@Table(name="Appointments")
public class Appointments {

	@Id
	@Column(name="app_id")
	@SequenceGenerator(sequenceName="MR_SEQ", name="MR_SEQ")
	@GeneratedValue(generator="MR_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer app_id; 	
	@Column(name="time_of")
	private String time;
	@Column(name="date_of")
	private String date;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Doctor_Appointments")
	private Doctor doctorAppointments;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Patient_Appointments")
	private Patient patientAppointments;

	/**No args constructor**/
	public Appointments() {
		super();
	}

	/**Except app_id constructor**/
	public Appointments(String time, String date, Doctor doctor, Patient patientAppointments) {
		super();
		this.time = time;
		this.date = date;
		this.doctorAppointments = doctor;
		this.patientAppointments = patientAppointments;
	}

	/**All args constructor**/
	public Appointments(Integer app_id, String time, String date, Doctor doctor, Patient patientAppointments) {
		super();
		this.app_id = app_id;
		this.time = time;
		this.date = date;
		this.doctorAppointments = doctor;
		this.patientAppointments = patientAppointments;
	}

	/**Sets the value of app_id**/
	public void setApp_id(Integer app_id) {this.app_id = app_id;}
	/**Sets the value of time**/
	public void setTime(String time) {this.time = time;}
	/**Sets the value of date**/
	public void setDate(String date) {this.date = date;}
	/**Sets the value of doctor**/
	public void setDoctor(Doctor doctor) {this.doctorAppointments = doctor;}
	/**Sets the value of patientAppointments**/
	public void setPatientAppointments(Patient patientAppointments) {this.patientAppointments = patientAppointments;}

	/**Sets the value of app_id**/
	public Integer getApp_id() {return app_id;}
	/**Sets the value of time**/
	public String getTime() {return time;}
	/**Sets the value of date**/
	public String getDate() {return date;}
	/**Sets the value of doctor**/
	public Doctor getDoctor() {return doctorAppointments;}
	/**Sets the value of patientAppointments**/
	public Patient getPatientAppointments() {return patientAppointments;}

	@Override
	public String toString() {
		return "Appointments [app_id=" + app_id + ", time=" + time + ", date=" + date + ", doctorAppointments="
				+ doctorAppointments + ", patientAppointments=" + patientAppointments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((app_id == null) ? 0 : app_id.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((doctorAppointments == null) ? 0 : doctorAppointments.hashCode());
		result = prime * result + ((patientAppointments == null) ? 0 : patientAppointments.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Appointments other = (Appointments) obj;
		if (app_id == null) {
			if (other.app_id != null)
				return false;
		} else if (!app_id.equals(other.app_id))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (doctorAppointments == null) {
			if (other.doctorAppointments != null)
				return false;
		} else if (!doctorAppointments.equals(other.doctorAppointments))
			return false;
		if (patientAppointments == null) {
			if (other.patientAppointments != null)
				return false;
		} else if (!patientAppointments.equals(other.patientAppointments))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	
}
