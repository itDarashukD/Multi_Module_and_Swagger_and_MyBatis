package com.example.cloud.converter;

import com.dto.example.model.Subscription;
import com.dto.example.model.SubscriptionRequestDto;
import com.dto.example.model.User;

import java.time.LocalDate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestDtoToSubscriptionConverter implements Converter<SubscriptionRequestDto, Subscription> {

    @Override
    public Subscription convert(SubscriptionRequestDto dto) {
        final User user = User.builder().id(dto.getUserId()).build();

        return Subscription.builder()
	       .id(dto.getId())
	       .user(user)
	       .startDate(LocalDate.now())
	       .build();
    }

}
