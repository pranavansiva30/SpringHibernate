package com.abc.st.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name="employee")
public class Employee {
 
 private Long Id;
 private String firstname;
 private String lastname;
 private Department department;
 private Set<Project> projects = new HashSet<Project>(
			0);
@Id
@Column(name="ID",unique=true,nullable=false)
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
@Column(name="firstname")
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
@Column(name="lastname")
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="dep_id",nullable=false)//default is  the concatenation of the name of the relationship in the owner side, _ (underscore), and the name of the primary key column in the owned side(department_id)
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
@ManyToMany(fetch=FetchType.LAZY)
@JoinTable(name="emp_projects",joinColumns={@JoinColumn(name="EMP_ID")},inverseJoinColumns={@JoinColumn(name="PRO_ID")})
public Set<Project> getProjects() {
	return projects;
}
public void setProjects(Set<Project> projects) {
	this.projects = projects;
}
 
 

}
