package com.example.cloud.converter;

import com.dto.example.model.Subscription;
import com.dto.example.model.SubscriptionResponseDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionToResponseDtoConverter implements Converter<Subscription, SubscriptionResponseDto> {

    @Override
    public SubscriptionResponseDto convert(Subscription ss) {
        return SubscriptionResponseDto.builder()
	       .id(ss.getId())
	       .userId(ss.getUser().getId())
	       .birthday(ss.getUser().getBirthDate().toString())
	       .startDate(ss.getStartDate().toString())
	       .build();
    }
}
