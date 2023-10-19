package com.example.cloud.serviceImpl;

import com.dto.example.model.SubscriptionRequestDto;
import com.dto.example.model.SubscriptionResponseDto;
import com.dto.example.model.User;
import com.example.api.serviceApi.SubscriptionService;
import com.example.cloud.converter.RequestDtoToSubscriptionConverter;
import com.example.cloud.converter.SubscriptionToResponseDtoConverter;
import com.example.cloud.repository.SubscriptionDao;
import com.example.cloud.repository.UserDao;
import com.dto.example.model.Subscription;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionDao dao;
    private UserDao userDao;
    private SubscriptionToResponseDtoConverter toResponseDtoConverter;
    private RequestDtoToSubscriptionConverter toSubscriptionConverter;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionDao dao,
            UserDao userDao,
            SubscriptionToResponseDtoConverter toResponseDtoConverter,
            RequestDtoToSubscriptionConverter toSubscriptionConverter) {
        this.dao = dao;
        this.userDao = userDao;
        this.toResponseDtoConverter = toResponseDtoConverter;
        this.toSubscriptionConverter = toSubscriptionConverter;
    }


    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        final List<Subscription> allSubscriptions = dao.getAllSubscriptions();
        return allSubscriptions.stream()
	       .map(ss -> toResponseDtoConverter.convert(ss))
	       .collect(Collectors.toList());
    }

    @Override
    public SubscriptionResponseDto getSubscription(long subscription_id) {
        final Subscription ss = dao.getSubscription(subscription_id);
        return toResponseDtoConverter.convert(ss);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto requestDto) {
        Subscription ss = toSubscriptionConverter.convert(requestDto);

          dao.createSubscription(ss);
        final User userFromDb = userDao.getUserById(ss.getUser().getId());
        ss.setUser(userFromDb);

       return toResponseDtoConverter.convert(ss);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto requestDto) {
        Subscription ss = toSubscriptionConverter.convert(requestDto);

        if (dao.isExistsById(ss.getId())) {
            dao.updateSubscription(ss);
        }else {
            throw new IllegalStateException(String.format("Subscription to update with id = %s is not present in DB", ss.getId()));
        }
        final User userFromDb = userDao.getUserById(ss.getUser().getId());
        ss.setUser(userFromDb);

        return toResponseDtoConverter.convert(ss);
    }

    @Override
    public Boolean deleteSubscription(long subscription_id) {
        if (dao.isExistsById(subscription_id)) {
            dao.deleteSubscription(subscription_id);
        }else {
            throw new IllegalStateException(String.format("Subscription to update with id = %s is not present in DB", subscription_id));
        }

        return true;
    }

}
