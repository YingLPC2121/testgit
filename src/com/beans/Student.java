package com.beans;

import java.util.Set;

public class Student {

	private int id;
	private String stuName;
	private Set<Teacher> teaSet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Set<Teacher> getTeaSet() {
		return teaSet;
	}
	public void setTeaSet(Set<Teacher> teaSet) {
		this.teaSet = teaSet;
	}
	
	
}
