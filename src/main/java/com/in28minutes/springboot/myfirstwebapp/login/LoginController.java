package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String pass, ModelMap model){
        model.put("name", name);
        logger.debug("Request Param is {}", name);

        if (authenticationService.authenticate(name, pass)){
            return "welcome";
        }
        else {
            model.put("errorMessage", "Invalid Credentials, Please try again!");
            return "login";
        }
    }
}
