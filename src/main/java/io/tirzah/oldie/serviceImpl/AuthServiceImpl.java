package io.tirzah.oldie.serviceImpl;

import io.tirzah.oldie.constants.ApplicationConstants;
import io.tirzah.oldie.dto.UserDto;
import io.tirzah.oldie.entity.Address;
import io.tirzah.oldie.entity.Role;
import io.tirzah.oldie.entity.User;
import io.tirzah.oldie.repository.AddressRepository;
import io.tirzah.oldie.repository.RoleRepository;
import io.tirzah.oldie.repository.UserRepository;
import io.tirzah.oldie.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final RoleRepository roleRepository;

    @Override
    public String register(UserDto userDto) {
        Address address = userDto.getAddress();
        addressRepository.save(address);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        User user = User.builder()
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNo(userDto.getPhoneNo())
                .build();
        return ApplicationConstants.USER_REGISTERED_SUCCESSFULLY;
    }

    @Override
    public String registerStaff(UserDto userDto) {
        Address address = userDto.getAddress();
        addressRepository.save(address);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_STAFF"));
        roles.add(roleRepository.findByName("ROLE_USER"));
        User user = User.builder()
                .address(address)
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .phoneNo(userDto.getPhoneNo())
                .roles(roles)
                .isVerified(false)
                .build();
        return ApplicationConstants.USER_REGISTERED_SUCCESSFULLY;

    }
}
