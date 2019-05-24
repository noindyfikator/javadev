package com.pgssoftware.springframework.domain.service;

import com.pgssoftware.springframework.domain.model.AppUser;
import com.pgssoftware.springframework.domain.model.Mapper;
import com.pgssoftware.springframework.domain.repository.UserRepository;
import com.pgssoftware.springframework.domain.repository.projection.UserLimited;
import com.pgssoftware.springframework.webui.dto.AppUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserLimited findFirstByFirstName(String firstName) {
        return userRepository.findFirstByFirstName(firstName);
    }

    public void addUser(AppUserDto appUserDto) {
        AppUser appUser = Mapper.map(appUserDto);
        userRepository.save(appUser);
    }

    @Override
    public List<AppUserDto> findAll() {
        return userRepository.findAll().stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByFirstNameOrLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameOrLastName(firstName, lastName).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByAgeLessThan(long age) {
        return userRepository.findByAgeLessThan(age).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByEmailStartingWith(String email) {
        return userRepository.findByEmailStartingWith(email).stream().map(Mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<AppUserDto> findByLastName(String lastName, Pageable pageable) {
        return userRepository.findByLastName(lastName, pageable).stream().map(Mapper::map).collect(Collectors.toList());
    }
}
