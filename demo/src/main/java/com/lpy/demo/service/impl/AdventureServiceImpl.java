package com.lpy.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lpy.demo.service.AdventureService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.remoting.httpinvoker.HttpInvokerClientConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class AdventureServiceImpl implements AdventureService {
    @Override
    public Object searchAdventure(String server, String zoom, String name) throws UnsupportedEncodingException {
        HttpHeaders headers=new HttpHeaders();
        String cookieAssemble="region="+ URLEncoder.encode(server,"utf-8")+"; server="+URLEncoder.encode(zoom,"utf-8")+"; serendipity=%E4%B8%8D%E9%99%90; search="+URLEncoder.encode(name,"utf-8")+"; PHPSESSID=qk4elf443j2kbkhdkjfvmb3525; think_var=zh-cn; uid=39392; token=d5eaed0e-7e3b-414a-a627-d2152fadae82";
        headers.add("Cookie",cookieAssemble);
        HttpEntity<String>  requestEntity=new HttpEntity<String>(null,headers);
        String urlAssemble="https://www.jx3mm.com/home/qyinfo?m=1&R="+URLEncoder.encode(server,"utf-8")+"&S="+URLEncoder.encode(zoom,"utf-8")+"&t="+URLEncoder.encode("绝世奇遇","utf-8")+"&u="+URLEncoder.encode("不限","utf-8")+"&n="+URLEncoder.encode(name,"utf-8")+"&csrf=1650766424965";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response=restTemplate.exchange(urlAssemble, HttpMethod.GET,requestEntity,String.class);
        JSONObject result = JSON.parseObject(response.toString());
        return null;
    }

    @Override
    public String urlAssembleTest(String server, String zoom, String name) throws UnsupportedEncodingException {
        return "region="+ URLEncoder.encode(server,"utf-8")+"; server="+URLEncoder.encode(zoom,"utf-8")+"; serendipity=%E4%B8%8D%E9%99%90; search="+URLEncoder.encode(name,"utf-8")+"; PHPSESSID=qk4elf443j2kbkhdkjfvmb3525; think_var=zh-cn; uid=39392; token=d5eaed0e-7e3b-414a-a627-d2152fadae82";
    }

    @Override
    public String urlASS(String server, String zoom, String name) throws UnsupportedEncodingException {
        String a="https://www.jx3mm.com/home/qyinfo?m=1&R=%E7%94%B5%E4%BF%A1%E4%BA%94%E5%8C%BA&S=%E4%B9%BE%E5%9D%A4%E4%B8%80%E6%8E%B7&t=&u=&n=%E6%AF%92%E8%90%9D&csrf=1650772682624";
        return "https://www.jx3mm.com/home/qyinfo?m=1&R="+URLEncoder.encode(server,"utf-8")+"&S="+URLEncoder.encode(zoom,"utf-8")+"&t="+URLEncoder.encode("绝世奇遇","utf-8")+"&u="+URLEncoder.encode("不限","utf-8")+"&n="+URLEncoder.encode(name,"utf-8")+"&csrf=1650766424965";
    }
}
