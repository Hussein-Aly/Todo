package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.java.JavaLoggingSystem;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String user, String pass){
        boolean isValidUsername = user.equalsIgnoreCase("Hussein");
        boolean isValidPassword = pass.equalsIgnoreCase("dummy");
        return isValidUsername && isValidPassword;
    }
}
