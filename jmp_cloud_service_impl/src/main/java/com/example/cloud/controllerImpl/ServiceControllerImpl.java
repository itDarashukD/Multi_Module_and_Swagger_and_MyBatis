package com.example.cloud.controllerImpl;

import com.dto.example.model.SubscriptionRequestDto;
import com.dto.example.model.SubscriptionResponseDto;
import com.example.api.serviceApi.SubscriptionService;
import com.example.restmodule.controller.ServiceController;
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


@RestController
@RequestMapping("/service")
@Api(tags = "ServiceController")
public class ServiceControllerImpl implements ServiceController {


    private SubscriptionService service;

    @Autowired
    public ServiceControllerImpl(SubscriptionService service) {
        this.service = service;
    }

    @ApiOperation(value = "retrieve all Subscriptions")
    @ApiResponses({
	   @ApiResponse(code = 200, message = "Success - Subscription list returned", response = SubscriptionResponseDto.class),
	   @ApiResponse(code = 404, message = "Not Found - Subscriptions not found"),
	   @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
	   @ApiResponse(code = 401, message = "Unauthorized - Authentication credentials are missing or invalid"),
	   @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @GetMapping("getSubscriptions")
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        return service.getAllSubscriptions();
    }

    @ApiOperation(value = "retrieve Subscriptions by id")
    @ApiResponses({
	   @ApiResponse(code = 200, message = "Success - Subscription found", response = SubscriptionResponseDto.class),
	   @ApiResponse(code = 404, message = "Not Found - Subscriptions not found"),
	   @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
	   @ApiResponse(code = 401, message = "Unauthorized - Authentication credentials are missing or invalid"),
	   @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @GetMapping("getSubscription/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable long id) {
        return service.getSubscription(id);
    }

    @ApiOperation(value = "Create a new Subscription")
    @ApiResponses({
	   @ApiResponse(code = 201, message = "Created - Resource successfully created", response = SubscriptionResponseDto.class),
	   @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
	   @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @PostMapping("createSubscription")
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        return service.createSubscription(subscriptionDto);
    }

    @ApiOperation(value = "Update a Subscription")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Updated - Resource successfully updated", response = SubscriptionResponseDto.class),
            @ApiResponse(code = 400, message = "Bad Request - The request is malformed or missing required parameters"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")})
    @PutMapping("updateSubscription")
    public SubscriptionResponseDto updateSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        return service.updateSubscription(subscriptionDto);
    }

    @ApiOperation(value = "Delete a Subscription by id")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No Content - Resource successfully deleted"),
            @ApiResponse(code = 404, message = "Not Found - Resource not found"),
            @ApiResponse(code = 500, message = "Internal Server Error - An error occurred while processing the request")
    })
    @DeleteMapping("deleteSubscription/{id}")
    public Boolean deleteSubscription(@PathVariable long id) {
        return service.deleteSubscription(id);
    }

}
