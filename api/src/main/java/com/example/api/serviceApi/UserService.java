package com.example.api.serviceApi;


import com.dto.example.model.UserRequestDto;
import com.dto.example.model.UserResponseDto;

import java.util.List;

public interface UserService {


    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(long userId);

    UserResponseDto createUser(UserRequestDto userDto);

    UserResponseDto updateUser(UserRequestDto userDto);

    Boolean deleteUser(long userId);
}
