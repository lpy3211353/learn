package com.lpy.demo.service.impl;


import com.lpy.demo.entity.InterfaceUrl;
import com.lpy.demo.entity.PrivateMethod;
import com.lpy.demo.service.InterfaceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceImplTest {
    @Autowired
    private InterfaceService service;

    private PrivateMethod privateMethod = new PrivateMethod();

    @Autowired
    private InterfaceUrl interfaceUrl;

    @Test
    public void test() {
        String result = service.testRest("20");
        System.out.println(result);
    }

    @Test
    public void test1() {
        service.testRest("200");
    }


    @Test
    public void test2() {
        System.out.println(interfaceUrl.getUrl());
    }

    @Test
    public void test3() {
        SimpleDateFormat format = new SimpleDateFormat("MM" + "月" + "dd" + "日" + " HH:mm");
        System.out.println(format.format(new Date()));
    }

    @Test
    public void test4() {
        int data = 89;
        int page = data / 10 + 1;
        List list = null;
        int temp = 1;
        List<List> arrList = new ArrayList<>(page);
        for (int i = 0; i < page; i++) {
            list = new ArrayList();
            for (int j = 0; j < 10 && temp <= data; j++) {
                list.add(temp);
                temp++;
            }
            arrList.add(list);
        }
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("这一页共有"+(arrList.get(i).size())+"项数据，分别为："+arrList.get(i));
        }
        Assertions.assertEquals(page, 9);
    }

}
