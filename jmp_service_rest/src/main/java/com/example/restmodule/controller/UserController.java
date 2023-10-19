package com.example.restmodule.controller;

import com.dto.example.model.UserRequestDto;
import com.dto.example.model.UserResponseDto;
import java.util.List;


public interface UserController {

      List<UserResponseDto> getAllUser();
      UserResponseDto getUserById(long userId);
      UserResponseDto createUser(UserRequestDto userDto);
      UserResponseDto updateUser(UserRequestDto userDto);
      Boolean deleteUser(long userId);

}
