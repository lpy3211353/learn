package com.lpy.demo.controller;

import com.lpy.demo.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {


    @Autowired
    InterfaceService interfaceService;

    @PostMapping(value = "/index")
    public Object testPost(){
        return interfaceService.testHttpURLConnection();
    }

    @PostMapping(value = "/rest")
    public Object testPost2(@RequestParam("value") String value){
        return interfaceService.testRest(value);
    }
}
