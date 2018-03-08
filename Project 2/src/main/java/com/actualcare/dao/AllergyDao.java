package com.actualcare.dao;

import com.actualcare.beans.Allergy;

public interface AllergyDao {
	
	public int insert(Allergy a);

	
	public void delete(Allergy a);
	
	public Allergy returnAllergy(int allergy_id);

	
	public Allergy getAllergyByPatId(Integer patient);

}
