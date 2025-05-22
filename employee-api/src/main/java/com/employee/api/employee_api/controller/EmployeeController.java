package com.employee.api.employee_api.controller;

import com.employee.api.employee_api.dto.EmployeeDTO;
import com.employee.api.employee_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }

    @PostMapping("/")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created Successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> getPaginatedEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getPaginatedEmployees());
    }


}
