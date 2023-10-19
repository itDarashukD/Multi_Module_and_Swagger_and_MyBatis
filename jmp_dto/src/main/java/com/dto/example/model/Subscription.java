package com.dto.example.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Subscription {

    private Long id;
    private User user;
    private LocalDate startDate;


}
