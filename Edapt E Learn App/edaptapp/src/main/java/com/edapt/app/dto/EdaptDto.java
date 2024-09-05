package com.edapt.app.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EdaptDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
