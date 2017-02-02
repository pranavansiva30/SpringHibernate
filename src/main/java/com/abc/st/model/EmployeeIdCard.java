package com.abc.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employeeid_card")
public class EmployeeIdCard {
private Long id;
private String cardNo;
private Employee employee;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id",unique=true,nullable=false)
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="card_no",unique=true,nullable=false)
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
@OneToOne
@JoinColumn(name="employee_id",unique=true)
@JsonIgnore
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}


}
