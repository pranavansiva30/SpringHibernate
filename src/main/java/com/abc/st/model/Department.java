package com.abc.st.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



import static javax.persistence.GenerationType.IDENTITY;



@Table(name="department")  
@Entity  
public class Department {
	
	private Integer id;
	private String name;
	private String departmentcode;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
    @Column(name="name") 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="departmentcode") 
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	
	
	

}
