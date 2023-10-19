package com.example.cloud.converter;

import com.dto.example.model.User;
import com.dto.example.model.UserRequestDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestDtoToUserConverter implements Converter<UserRequestDto,User> {


    @Override
    public User convert(UserRequestDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate birthDate = LocalDate.parse(dto.getBirthday(),formatter);

        return User.builder()
	    .id(dto.getId())
	    .name(dto.getName())
	    .surname(dto.getSurname())
	    .birthDate(birthDate)
	    .build();

    }


}
