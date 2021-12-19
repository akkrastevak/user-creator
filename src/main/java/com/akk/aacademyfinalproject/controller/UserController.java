package com.akk.aacademyfinalproject.controller;

import com.akk.aacademyfinalproject.converter.UserConverter;
import com.akk.aacademyfinalproject.dto.UserDto;
import com.akk.aacademyfinalproject.entity.User;
import com.akk.aacademyfinalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "users/")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @Autowired
    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping
    public ResponseEntity<Set<UserDto>>findAll(){
//Връщаме set от Users, foreach-ваме го със stream, с map ги конвертираме към userDto и ги връщаме необратно в нов Set.
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(userConverter::toUserDto)
                .collect(Collectors.toSet()));
    }
//Конвертираме userDto към user и го запазваме в нов user. Новият user го конвертираме към userDto
    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        User user = userConverter.toUser(userDto);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(userConverter.toUserDto(savedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
