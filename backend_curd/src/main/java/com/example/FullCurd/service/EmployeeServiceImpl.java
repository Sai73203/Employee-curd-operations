package com.example.FullCurd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FullCurd.dto.EmployeeDto;
import com.example.FullCurd.entity.EmployeeEntity;
import com.example.FullCurd.mapper.EmployeeMapper;
import com.example.FullCurd.repo.EmployeeRepo;
import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto dto) {
		
		
		EmployeeEntity emp = EmployeeMapper.toEntity(dto);
		
		EmployeeEntity savedEmployee = employeeRepo.save(emp);
		
		return EmployeeMapper.toDto(savedEmployee);
	}
	
	public List<EmployeeDto> getAllEmployees(){
		
		List<EmployeeEntity> lst = employeeRepo.findAll();
		
		return lst.stream().map(emp->EmployeeMapper.toDto(emp)).toList();
		
	}
	
	public EmployeeDto getEmployeeById(int id) {
		
		
		EmployeeEntity emp = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with this id: "+id));
		
		return EmployeeMapper.toDto(emp);
	}
	
	public EmployeeDto updateEmployeeById(int id,EmployeeDto dto) {
		
		EmployeeEntity emp = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found: "+id));
		
		
		emp.setName(dto.getName());
		emp.setTech(dto.getTech());
		emp.setSalary(dto.getSalary());
		
		employeeRepo.save(emp);
		
		return EmployeeMapper.toDto(emp);
		
	}
	
	public String deleteEmployeeById(int id) {
		
		EmployeeEntity emp = employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found: "+id));
		employeeRepo.deleteById(emp.getId());
		
		return "employee deleted successfully";
		
	}
	
	

}
