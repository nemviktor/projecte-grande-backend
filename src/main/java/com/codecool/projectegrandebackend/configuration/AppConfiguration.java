package com.codecool.projectegrandebackend.configuration;

import com.codecool.projectegrandebackend.model.EV;
import com.codecool.projectegrandebackend.model.User;
import com.codecool.projectegrandebackend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfiguration {

    private final PasswordEncoder passwordEncoder;

    public AppConfiguration() {
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    @Profile("production")
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User betaUser = User.builder()
                    .username("test_bela")
                    .email("bela@takeaction.com")
                    .password(passwordEncoder.encode("5678"))
                    .role("ROLE_USER") // other is ROLE_ADMIN
                    .build();
            userRepository.save(betaUser);
        };
    }

}
