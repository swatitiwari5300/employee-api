package com.employee.api.employee_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {

    int id;
    String name;
    String department;
}
