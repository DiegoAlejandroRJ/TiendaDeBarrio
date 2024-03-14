package org.example.controller;


import jakarta.annotation.security.RolesAllowed;
import org.example.dto.UserDto;
import org.example.dto.UserResponseDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.utils.Constants.ADMIN_ROLE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
        //loadSampleUsers();
    }

    public void loadSampleUsers() {
        LocalDate fecha = LocalDate.of(2024, 2, 22);
        UserDto userEntity = new UserDto("Diego", "Ramirez", fecha, "diego@mail.com", "passw0rd");
        userService.createUser(userEntity);
        UserDto adminUserEntity = new UserDto("Diego", "Ramirez", fecha, "diego@mail.com", "passw0rd");
        UserResponseDto userCreated = userService.createUser(adminUserEntity);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        try{
            List<UserResponseDto> usersResponseDto = userService.getAllUsers();
            if (usersResponseDto.isEmpty()){
                return new ResponseEntity<>(usersResponseDto, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity("An error has occurred while retrieving users", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable String id){
        try {
            return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + id + " doesn't exist in the data base", HttpStatus.NOT_FOUND);
        }
    }

    //@RolesAllowed(ADMIN_ROLE)
    @PostMapping("/createAdmin")
    public ResponseEntity<UserResponseDto> createUserAdmin(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUserAdmin(userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable String id, @RequestBody UserDto userDto){
        try {
            Boolean isUpdated = userService.updateUser(id, userDto);
            if (isUpdated){
                return new ResponseEntity("The user updated ok", HttpStatus.OK);
            }else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + id + " doesn't exist in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id){
        try {
            Boolean isDeleted = userService.deleteUser(id);
            if (isDeleted){
                return new ResponseEntity(true, HttpStatus.OK);
            }else {
                return new ResponseEntity(false, HttpStatus.NOT_FOUND);
            }

        }catch (NoSuchElementException e){
            return new ResponseEntity("The user " + id + " doesn't exist in the data base", HttpStatus.NOT_FOUND);
        }
    }
}
