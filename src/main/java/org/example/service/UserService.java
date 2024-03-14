package org.example.service;

import org.example.dto.UserDto;
import org.example.dto.UserResponseDto;
import org.example.model.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto findUserById(String id);
    User findByEmail(String email);
    UserResponseDto createUser(UserDto userDto);
    UserResponseDto createUserAdmin(UserDto userDto);
    Boolean updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
}
