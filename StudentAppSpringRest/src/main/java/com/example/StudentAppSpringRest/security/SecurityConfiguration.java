package com.example.StudentAppSpringRest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails levelOne = User.builder()
                .username("levelOne")
                .password("{noop}test123")
                .roles("LevelOne")
                .build();

        UserDetails levelTwo = User.builder()
                .username("levelTwo")
                .password("{noop}test123")
                .roles("LevelTwo")
                .build();

        UserDetails levelThree = User.builder()
                .username("levelThree")
                .password("{noop}test123")
                .roles("LevelThree")
                .build();

        return new InMemoryUserDetailsManager(levelOne, levelTwo, levelThree);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("LevelOne")
                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("LevelOne")
                        .requestMatchers(HttpMethod.POST, "/api/**").hasRole("LevelTwo")
                        .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("LevelTwo")
                        .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("LevelThree")
    );
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
