package com.pgssoftware.springframework.webui.controller;

import com.pgssoftware.springframework.domain.service.UserService;
import com.pgssoftware.springframework.webui.dto.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody AppUserDto appUserDto) {
        userService.addUser(appUserDto);
    }

    @GetMapping
    public List<AppUserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/findByFirstNameAndLastName")
    public List<AppUserDto> findByFirstNameAndLastName(String firstName, String lastName) {
        return userService.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/findByFirstNameOrLastName")
    public List<AppUserDto> findByFirstNameOrLastName(String firstName, String lastName) {
        return userService.findByFirstNameOrLastName(firstName, lastName);
    }

    @GetMapping("/findByFirstName")
    public List<AppUserDto> findByFirstName(String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping("/findByAgeLessThan")
    public List<AppUserDto> findByAgeLessThan(long age) {
        return userService.findByAgeLessThan(age);
    }

    @GetMapping("/findByEmailStartingWith")
    public List<AppUserDto> findByEmailStartingWith(String email) {
        return userService.findByEmailStartingWith(email);
    }

    @GetMapping("/findByLastName/{lastName}")
    public List<AppUserDto> findByLastName(@PathVariable String lastName, @PageableDefault Pageable pageable) {
        return userService.findByLastName(lastName, pageable);
    }
}
