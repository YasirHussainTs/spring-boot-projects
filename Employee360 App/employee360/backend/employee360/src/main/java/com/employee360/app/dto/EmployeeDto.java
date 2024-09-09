package com.employee360.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
