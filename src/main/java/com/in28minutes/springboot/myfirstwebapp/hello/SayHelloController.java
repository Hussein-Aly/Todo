package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! How you doing?";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    // D:\Spring\myfirstwebapp\src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
    // D:\Spring\myfirstwebapp\src\main\resources\META-INF\resources\WEB-INF\jsp\welcome.jsp
    // D:\Spring\myfirstwebapp\src\main\resources\META-INF\resources\WEB-INF\jsp\login.jsp
    // D:\Spring\myfirstwebapp\src\main\resources\META-INF\resources\WEB-INF\jsp\todos.jsp
    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        // In order to create a jsp resource you have to follow this convention:
        // -> src/main/resources/META-INF/resources/WEB-INF/jsp
        return "sayHello";
    }

}
