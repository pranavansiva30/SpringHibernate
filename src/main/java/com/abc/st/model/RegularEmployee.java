package com.abc.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="regular_employee")
@PrimaryKeyJoinColumn(name="EMP_ID")
public class RegularEmployee extends Employee{
private Double salary;
private Double bonus;
@Column(name="salary")
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
@Column(name="bonus")
public Double getBonus() {
	return bonus;
}
public void setBonus(Double bonus) {
	this.bonus = bonus;
}


}
