package com.ajay.springsecurity1.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/myAccount", "myLoans", "/myCards", "/myBalance").authenticated()// secure this endpoint
                        .requestMatchers("/notices", "/contact").permitAll() // allow this endpoint
                )
                .formLogin(Customizer.withDefaults())// default login page
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable()) // disable form login
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails details = User.withUsername("ajaydinakar").password("{SHA-256}e4ef94cd9977e3b3de3952fd207ff41e877ef8af81b3dbd7f682d452b8f039d4").authorities("read").build();
        return new InMemoryUserDetailsManager(details);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker passwordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker(); //
    }
}