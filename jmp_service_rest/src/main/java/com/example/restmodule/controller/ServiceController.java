package com.example.restmodule.controller;

import com.dto.example.model.SubscriptionRequestDto;
import com.dto.example.model.SubscriptionResponseDto;
import java.util.List;


public interface ServiceController {

      List<SubscriptionResponseDto> getAllSubscriptions();
      SubscriptionResponseDto getSubscription(long userId);
      SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionDto);
      SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionDto);
      Boolean deleteSubscription(long userId);

}
