package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
// In order to create a jsp resource you have to follow this convention:
// -> src/main/resources/META-INF/resources/WEB-INF/jsp

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private AuthenticationService authenticationService;

    public WelcomeController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToLogin(ModelMap model){
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}
