package com.actualcare.dao;

import com.actualcare.beans.PersonalInfo;

public interface PersonalInfoDao {
	
	public int insert(PersonalInfo pi);

	
	public void delete(PersonalInfo pi);

	
	public PersonalInfo returnPersonalInfo(int personal_id);
	
	public PersonalInfo getPersonalInfoByPatId(Integer patient);


}
