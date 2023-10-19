package com.dto.example.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubscriptionResponseDto {


    private Long id;
    private Long userId;
    private String startDate;
    private String birthday;


}
