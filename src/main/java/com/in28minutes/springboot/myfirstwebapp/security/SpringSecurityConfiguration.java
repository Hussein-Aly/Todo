package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //database or lda
    //in memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        UserDetails userDetails = createNewUser("in28minutes", "dummy");
        UserDetails userDetails1 = createNewUser("Hussein", "dummy1");
        UserDetails userDetails2 = createNewUser("Aly", "dummy2");


        return new InMemoryUserDetailsManager(userDetails,userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        // lambda function
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username).
                password(password).
                roles("USER, ADMIN").
                build();

        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity allows to configure web based security
        // When we override SecurityFilterChain...we need to redefine the entire chain again!
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // if there is unauth. request we are configuring form login to show the page where
        // we can collect username and password
        http.formLogin(Customizer.withDefaults());

        // disabling for h2
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
