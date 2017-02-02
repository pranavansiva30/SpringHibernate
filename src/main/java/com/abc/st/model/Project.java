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
import javax.persistence.ManyToMany;

@Entity
@Table(name="project")
public class Project {
private Long Id;
private String project_code;
private String description;
private Set<Employee> employees = new HashSet<Employee>(
		0);

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="project_id",nullable=false,unique=true)
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
@Column(name="project_code",nullable=false,unique=true)
public String getProject_code() {
	return project_code;
}
public void setProject_code(String project_code) {
	this.project_code = project_code;
}
@Column(name="project_description")
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@ManyToMany(fetch=FetchType.LAZY,mappedBy="projects")
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}


}
