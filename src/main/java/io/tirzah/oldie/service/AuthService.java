package io.tirzah.oldie.service;

import io.tirzah.oldie.dto.UserDto;

public interface AuthService {


    String register(UserDto userDto);

    String registerStaff(UserDto userDto);

}
