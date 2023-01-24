package io.tirzah.oldie.utils;

import io.tirzah.oldie.entity.Role;
import io.tirzah.oldie.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RoleUtil {

        public static final String ROLE_USER = "ROLE_USER";
        public static final String ROLE_ADMIN = "ROLE_ADMIN";

        //public static final String ROLE_STAFF = "ROLE_STAFF";

        @Autowired
        RoleRepository roleRepository;

        @Bean
        CommandLineRunner runner(RoleRepository roleRepository){
            return args -> {
                if (roleRepository.count() == 0){
                    roleRepository.save(new Role(ROLE_USER));
                    roleRepository.save(new Role(ROLE_ADMIN));
                }
            };
        }
}

