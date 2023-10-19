package com.example.cloud.repository;

import com.dto.example.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao {

    List<User> getAllUsers();

    User getUserById(@Param("id") long id);

    long createUser(User user);

    long updateUser(User user);

    void deleteUser(@Param("id") long id);

    Boolean isExistsById(@Param("id") long id);

}
