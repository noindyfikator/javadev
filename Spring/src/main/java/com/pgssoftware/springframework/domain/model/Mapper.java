package com.pgssoftware.springframework.domain.model;

import com.pgssoftware.springframework.webui.dto.AppUserDto;

public class Mapper {

    public static AppUser map(AppUserDto appUserDto) {
        AppUser appUser = new AppUser();
        appUser.setLastName(appUserDto.getLastName());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setUsername(appUserDto.getUsername());
        appUser.setPassword(appUserDto.getPassword());
        return appUser;
    }

    public static AppUserDto map(AppUser appUser) {
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setLastName(appUser.getLastName());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setFirstName(appUser.getFirstName());
        appUserDto.setUsername(appUser.getUsername());
        appUser.setPassword(appUser.getPassword());
        return appUserDto;
    }
}
