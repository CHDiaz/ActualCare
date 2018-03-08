package com.actualcare.beans;

public class Test {
	private int id;
	private String name;
	public Test(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Test() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
