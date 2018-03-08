package com.actualcare.dao;

import com.actualcare.beans.Sympton;

public interface SymptonDao {

	public int insert(Sympton s);

	
	public void delete(Sympton s);
	
	public Sympton returnSympton(int sympton_id);

	
	public Sympton getSymptonByPatId(Integer patient);

}
