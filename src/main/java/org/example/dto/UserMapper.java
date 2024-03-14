package org.example.dto;

import org.example.model.User;

import java.time.LocalDate;

public class UserMapper {

    public static UserResponseDto userToUserResponseDto(User user){
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                LocalDate.of(1950, 2, 15), user.getEmail()
        );
    }

    public static User userDtoToUser(UserDto userDto){
        return new User(
                userDto.getName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
