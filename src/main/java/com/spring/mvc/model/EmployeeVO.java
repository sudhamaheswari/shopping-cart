package com.spring.mvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="employee")
@Component
public class EmployeeVO implements Serializable 
{
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private Integer id;
	private String firstName;
	private String lastName;
    
	public EmployeeVO(){
		
	}
	public EmployeeVO(Integer id,String firstName,String lastName)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}