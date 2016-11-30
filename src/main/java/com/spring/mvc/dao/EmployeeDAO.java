package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.model.EmployeeVO;

public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();
}