package com.example.cloud.controllerImpl;

import com.dto.example.model.UserRequestDto;
import com.dto.example.model.UserResponseDto;
import com.example.api.serviceApi.UserService;
import com.example.restmodule.controller.UserController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "UserController")
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

    private UserService service;

    @Autowired
    public UserControllerImpl(UserService service) {
        this.service = service;
    }


    @ApiOperation(value = "retrieve all Subscriptions")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success - User list returned", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found - User not found"),
            @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @GetMapping("getUsers")
    public List<UserResponseDto> getAllUser() {
        return service.getAllUsers();
    }

    @ApiOperation(value = "retrieve User by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success - User found and returned", response = UserResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found - Subscriptions not found"),
            @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @GetMapping("getUser/{id}")
    public UserResponseDto getUserById(@PathVariable long id) {
        return service.getUserById(id);
    }

    @ApiOperation(value = "Create a new User")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created - User successfully created", response = UserResponseDto.class),
            @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @PostMapping("createUser")
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        return service.createUser(userDto);
    }

    @ApiOperation(value = "Update an User")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Updated - Resource successfully updated", response = UserResponseDto.class),
            @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @PutMapping("updateUser")
    public UserResponseDto updateUser(@RequestBody UserRequestDto userDto) {
        return service.updateUser(userDto);
    }

    @ApiOperation(value = "Delete an User by id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No Content - Resource successfully deleted"),
            @ApiResponse(code = 404, message = "Not Found - Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")
    })
    @DeleteMapping("deleteUser/{id}")
    public Boolean deleteUser(@PathVariable long id) {
        return service.deleteUser(id);
    }

}
