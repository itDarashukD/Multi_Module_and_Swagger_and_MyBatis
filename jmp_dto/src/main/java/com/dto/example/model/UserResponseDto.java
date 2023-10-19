package com.dto.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDto {


    private Long id;
    private String name;
    private String surname;
    private String birthday;


}
