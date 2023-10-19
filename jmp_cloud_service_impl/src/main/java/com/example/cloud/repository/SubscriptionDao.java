package com.example.cloud.repository;

import com.dto.example.model.Subscription;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SubscriptionDao {

    List<Subscription> getAllSubscriptions();

    Subscription getSubscription(@Param("id") long id);

    long createSubscription(Subscription subscription);

    long updateSubscription(Subscription subscription);

    void deleteSubscription(long id);

    Boolean isExistsById(@Param("id") long id);
}
