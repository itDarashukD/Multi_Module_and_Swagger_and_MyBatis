package com.dto.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubscriptionRequestDto {


    private Long id;
    private Long userId;

}
