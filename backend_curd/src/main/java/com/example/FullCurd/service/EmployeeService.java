package com.example.FullCurd.service;


import com.example.FullCurd.dto.EmployeeDto;

import java.util.*;


public interface EmployeeService {
	
	public EmployeeDto createEmployee(EmployeeDto dto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto getEmployeeById(int id);
	
	public EmployeeDto updateEmployeeById(int id,EmployeeDto dto);
	
	public String deleteEmployeeById(int id);
	
	

}
