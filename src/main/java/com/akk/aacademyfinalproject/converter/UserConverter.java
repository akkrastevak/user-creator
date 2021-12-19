package com.akk.aacademyfinalproject.converter;

import com.akk.aacademyfinalproject.dto.UserDto;
import com.akk.aacademyfinalproject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDto toUserDto(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public User toUser(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();
    }
}
