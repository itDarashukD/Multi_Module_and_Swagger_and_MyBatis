package com.example.cloud.serviceImpl;

import com.dto.example.model.User;
import com.dto.example.model.UserRequestDto;
import com.dto.example.model.UserResponseDto;
import com.example.api.serviceApi.UserService;
import com.example.cloud.converter.RequestDtoToUserConverter;
import com.example.cloud.converter.UserToResponseDtoConverter;
import com.example.cloud.repository.UserDao;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    private UserDao dao;
    private RequestDtoToUserConverter toUserConverter;
    private UserToResponseDtoConverter toDtoConverter;

    @Autowired
    public UserServiceImpl(UserDao dao, RequestDtoToUserConverter toUserConverter, UserToResponseDtoConverter toDtoConverter) {
        this.dao = dao;
        this.toUserConverter = toUserConverter;
        this.toDtoConverter = toDtoConverter;
    }


    @Override
    public List<UserResponseDto> getAllUsers() {
        final List<User> allUsers = dao.getAllUsers();
        return allUsers.stream()
	       .map(user -> toDtoConverter.convert(user))
	       .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(long id) {
        final User userFomDb = dao.getUserById(id);

        return toDtoConverter.convert(userFomDb);
    }

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User userFromRequest = toUserConverter.convert(requestDto);

        dao.createUser(userFromRequest);

        return toDtoConverter.convert(userFromRequest);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto requestDto) {
        User userFromRequest = toUserConverter.convert(requestDto);

        if (dao.isExistsById(userFromRequest.getId())) {
            dao.updateUser(userFromRequest);
        }else
            throw new IllegalStateException(String.format("User to update with id = %s is not present in DB", userFromRequest.getId()));

        return toDtoConverter.convert(userFromRequest);
    }

    @Override
    public Boolean deleteUser(long id) {
        if (dao.isExistsById(id)) {
            dao.deleteUser(id);
        }else
            throw new IllegalStateException(String.format("User to delete with id = %s is not present in DB", id));

        return true;
    }


}
