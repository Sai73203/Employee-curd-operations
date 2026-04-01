package com.example.FullCurd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FullCurd.entity.EmployeeEntity;



public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{

	
}
