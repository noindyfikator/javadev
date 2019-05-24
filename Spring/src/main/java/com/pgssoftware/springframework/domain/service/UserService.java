package com.pgssoftware.springframework.domain.service;

import com.pgssoftware.springframework.webui.dto.AppUserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    void addUser(AppUserDto appUserDto);

    List<AppUserDto> findAll();

    List<AppUserDto> findByFirstNameAndLastName(String firstName, String lastName);

    List<AppUserDto> findByFirstNameOrLastName(String firstName, String lastName);

    List<AppUserDto> findByFirstName(String firstName);

    List<AppUserDto> findByAgeLessThan(long age);

    List<AppUserDto> findByEmailStartingWith(String email);

    List<AppUserDto> findByLastName(String lastName, Pageable pageable);
}
