package com.example.api.serviceApi;


import com.dto.example.model.SubscriptionRequestDto;
import com.dto.example.model.SubscriptionResponseDto;

import java.util.List;

public interface SubscriptionService {


    List<SubscriptionResponseDto> getAllSubscriptions();

    SubscriptionResponseDto getSubscription(long id);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto);

    Boolean deleteSubscription(long id);
}
