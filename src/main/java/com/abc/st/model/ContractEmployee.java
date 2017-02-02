package com.abc.st.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="contract_employee")
@PrimaryKeyJoinColumn(name="EMP_ID")
public class ContractEmployee extends Employee {
private Double pay_per_hour;
private Long contract_duration;
@Column(name="pay_per_hour")
public Double getPay_per_hour() {
	return pay_per_hour;
}
public void setPay_per_hour(Double pay_per_hour) {
	this.pay_per_hour = pay_per_hour;
}
@Column(name="contract_duration")
public Long getContract_duration() {
	return contract_duration;
}
public void setContract_duration(Long contract_duration) {
	this.contract_duration = contract_duration;
}


}
