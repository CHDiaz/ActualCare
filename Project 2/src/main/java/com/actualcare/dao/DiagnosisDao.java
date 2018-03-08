package com.actualcare.dao;

import com.actualcare.beans.Diagnosis;

public interface DiagnosisDao {
	
	public int insert(Diagnosis d);

	
	public void delete(Diagnosis d);
	
	public Diagnosis returnDiagnosis(int diagnosis_id);

	
	public Diagnosis getDiagnosisByPatId(Integer patient);
}
