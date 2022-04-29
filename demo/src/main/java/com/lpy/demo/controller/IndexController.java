package com.lpy.demo.controller;

import com.lpy.demo.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

//@RestController
@Controller
public class IndexController {


    @Autowired
    InterfaceService interfaceService;

    @PostMapping(value = "/index")
    public Object testPost() {
        return interfaceService.testHttpURLConnection();
    }

    @PostMapping(value = "/rest")
    public Object testPost2(@RequestParam("value") String value) {
        return interfaceService.testRest(value);
    }

    @GetMapping(value = "/co")
    public String testPost3(HttpServletResponse response) {
        Cookie cookie = new Cookie("username", "lpy");
        response.addCookie(cookie);
        return "yes!";
    }

    @GetMapping(value = "/coo")
    public String testPost4(@CookieValue(value = "username",defaultValue = "null") String username){
        if ("null".equals(username)){
            return "redirect:co";
        }
        return "hello!"+username;
    }
}
