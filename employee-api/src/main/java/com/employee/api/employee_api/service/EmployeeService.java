package com.employee.api.employee_api.service;

import com.employee.api.employee_api.dto.EmployeeDTO;
import com.employee.api.employee_api.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<EmployeeDTO> employeeDTOList = new ArrayList<>();

    public void createEmployee(EmployeeDTO employeeDTO){
        employeeDTOList.add(employeeDTO);
    }

    public EmployeeDTO getEmployeeById(int id){
        EmployeeDTO employeeDTO = employeeDTOList
                .stream()
                .filter(emp -> emp.getId()==id)
                .findAny()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with the given id"));
        return employeeDTO;
    }

    public List<EmployeeDTO> getPaginatedEmployees(int page, int size){
        int start = page * size;
        int end = Math.min(start+size, employeeDTOList.size());

        return employeeDTOList.subList(start, end);
    }
}
