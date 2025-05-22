package com.employee.api.employee_api.service;

import com.employee.api.employee_api.dto.EmployeeDTO;
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
        return EmployeeDTO.builder().build();
    }

    public List<EmployeeDTO> getPaginatedEmployees(){
        return new ArrayList<>();
    }
}
