package com.lpy.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lpy.demo.entity.InterfaceUrl;
import com.lpy.demo.service.InterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceImpl implements InterfaceService {
    private static Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InterfaceUrl interfaceUrl;

    @Override
    public Object testHttpURLConnection() {
        String str = "{\n" +
                "  \"trigger-type\": \"network\",\n" +
                "  \"trigger-location\": \"cn-hangzhou\",\n" +
                "  \"trigger-severity\": \"MAX\",\n" +
                "  \"trigger-policy\": \"package errors > 5%\",\n" +
                "  \"trigger-event\": \"inbound tcp package errors is 20%\",\n" +
                "  \"trigger-check\": \"tcp package error percentage\",\n" +
                "  \"trigger-value\": \"20\",\n" +
                "  \"trigger-time\":"+System.currentTimeMillis()+",\n" +
                "  \"metadata\": [\n" +
                "    {\n" +
                "      \"agent\": \"SERVER\",\n" +
                "      \"ip\": \"141.219.XX.XX\",\n" +
                "      \"fqdn\": \"websrv1.damenport.org\",\n" +
                "      \"microServiceId\": \"ms-login-2251\",\n" +
                "      \"accountId\": \"1504000433993\",\n" +
                "      \"service\": \"login-0\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"agent\": \"CONTAINER\",\n" +
                "      \"ip\": \"172.1.XX.XX\",\n" +
                "      \"fqdn\": \"websrv2.damenport.org\",\n" +
                "      \"microServiceId\": \"ms-login-2252\",\n" +
                "      \"accountId\": \"129930302939\",\n" +
                "      \"service\": \"login-1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"equipments\": [\n" +
                "    {\n" +
                "      \"equipmentId\": \"112\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"equipmentId\": \"113\"\n" +
                "    }\n" +
                "  ]\n" +
                "}" ;
        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(str);
        String responseContent = null;
        try {
            URL url = new URL(interfaceUrl.getUrl());
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            connection.getOutputStream().write(str.getBytes());
            responseContent = StreamUtils.copyToString(connection.getInputStream(), Charset.forName("UTF-8"));
            logger.info("connect.getInputStream:{}",connection.getInputStream());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("responseContent:{}",responseContent);
        Object json = JSON.parse(responseContent);
        return json;
    }

    @Override
    public String testRest(String value) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String str = "{\n" +
                "  \"trigger-type\": \"network\",\n" +
                "  \"trigger-location\": \"cn-hangzhou\",\n" +
                "  \"trigger-severity\": \"MAX\",\n" +
                "  \"trigger-policy\": \"package errors > 15%\",\n" +
                "  \"trigger-event\": \"inbound tcp package errors is 20%\",\n" +
                "  \"trigger-check\": \"tcp package error percentage\",\n" +
                "  \"trigger-value\": \""+value+"\",\n" +
                "  \"trigger-time\":"+System.currentTimeMillis()+",\n" +
                "  \"metadata\": [\n" +
                "    {\n" +
                "      \"agent\": \"SERVER\",\n" +
                "      \"ip\": \"141.219.XX.XX\",\n" +
                "      \"fqdn\": \"websrv1.damenport.org\",\n" +
                "      \"microServiceId\": \"ms-login-2251\",\n" +
                "      \"accountId\": \"1504000433993\",\n" +
                "      \"service\": \"login-0\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"agent\": \"CONTAINER\",\n" +
                "      \"ip\": \"172.1.XX.XX\",\n" +
                "      \"fqdn\": \"websrv2.damenport.org\",\n" +
                "      \"microServiceId\": \"ms-login-2252\",\n" +
                "      \"accountId\": \"129930302939\",\n" +
                "      \"service\": \"login-1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"equipments\": [\n" +
                "    {\n" +
                "      \"equipmentId\": \"112\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"equipmentId\": \"113\"\n" +
                "    }\n" +
                "  ]\n" +
                "}" ;
        HttpEntity<String> entity = new HttpEntity<>(str, headers);
        String url = interfaceUrl.getUrl();
        ResponseEntity<String> postEntity = restTemplate.postForEntity(url, entity, String.class);
        String body = postEntity.getBody();
        return body;
    }
}
