package io.tirzah.oldie.serviceImpl;

import io.tirzah.oldie.entity.Role;
import io.tirzah.oldie.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl {

    @Autowired
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    Role findByName(String name){
        return roleRepository.findByName(name);
    }

    Role save(Role role){
        return roleRepository.save(role);
    }

}
