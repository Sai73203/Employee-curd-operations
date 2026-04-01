package com.example.FullCurd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FullCurd.dto.EmployeeDto;
import com.example.FullCurd.service.EmployeeService;




import java.util.List;

@RestController   
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE
    @PostMapping("/createEmp")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto dto) {

        EmployeeDto saved = employeeService.createEmployee(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // GET ALL
    @GetMapping("/allEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

        List<EmployeeDto> list = employeeService.getAllEmployees();

        return ResponseEntity.ok(list);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {

        EmployeeDto dto = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(dto);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable int id, @RequestBody EmployeeDto dto) {

        EmployeeDto updated = employeeService.updateEmployeeById(id, dto);

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {

        employeeService.deleteEmployeeById(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}