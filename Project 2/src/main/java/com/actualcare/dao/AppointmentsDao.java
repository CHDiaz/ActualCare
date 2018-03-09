package com.actualcare.dao;

import com.actualcare.beans.Appointments;

public interface AppointmentsDao {

	public int insert(Appointments a);

	
	public void delete(Appointments a);
	
	public Appointments returnAppointments(int app_id);

}
