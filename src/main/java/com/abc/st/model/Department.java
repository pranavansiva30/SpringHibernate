package com.abc.st.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;



@Table(name="department")  
@Entity  
public class Department {
	
	private Integer id;
	private String name;
	private String departmentcode;
	private Set<Employee> employees = new HashSet<Employee>(
			0);

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
	@Column(name="departmentcode",unique=true,nullable=false) 
	public String getDepartmentcode() {
		return departmentcode;
	}
	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")//one to many Bidirectional
	@JsonIgnore
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
