package com.example.FullCurd.mapper;

import com.example.FullCurd.dto.EmployeeDto;
import com.example.FullCurd.entity.EmployeeEntity;

public class EmployeeMapper {

    // DTO → Entity
    public static EmployeeEntity toEntity(EmployeeDto dto) {

        if (dto == null) {
            return null;
        }

        EmployeeEntity emp = new EmployeeEntity();

        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setTech(dto.getTech());
        emp.setSalary(dto.getSalary());

        return emp;
    }

    // Entity → DTO
    public static EmployeeDto toDto(EmployeeEntity employee) {

        if (employee == null) {
            return null;
        }

        EmployeeDto dto = new EmployeeDto();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setTech(employee.getTech());
        dto.setSalary(employee.getSalary());

        return dto;
    }
}