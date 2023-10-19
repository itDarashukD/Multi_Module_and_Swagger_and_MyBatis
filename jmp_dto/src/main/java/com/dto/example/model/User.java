package com.dto.example.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;


}
