package com.lpy.demo.service.impl;


import com.lpy.demo.DemoApplication;
import com.lpy.demo.entity.InterfaceUrl;
import com.lpy.demo.entity.PrivateMethod;
import com.lpy.demo.service.AdventureService;
import com.lpy.demo.service.InterfaceService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
public class ServiceImplTest {
    @Autowired
    private InterfaceService service;

    @Autowired
    private AdventureService adventureService;

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

    @Test
    @SneakyThrows
    public void test5(){
        System.out.println(adventureService.searchAdventure("电信五区","乾坤一掷","毒萝"));
    }
    @Test
    @SneakyThrows
    public void test6(){
        Assertions.assertEquals(adventureService.urlAssembleTest("电信五区","乾坤一掷","毒萝"),"region=%E7%94%B5%E4%BF%A1%E4%BA%94%E5%8C%BA; server=%E4%B9%BE%E5%9D%A4%E4%B8%80%E6%8E%B7; serendipity=%E4%B8%8D%E9%99%90; search=%E6%AF%92%E8%90%9D; PHPSESSID=qk4elf443j2kbkhdkjfvmb3525; think_var=zh-cn; uid=39392; token=d5eaed0e-7e3b-414a-a627-d2152fadae82");
        System.out.println(adventureService.urlAssembleTest("电信五区","乾坤一掷","毒萝"));
    }

    @Test
    @SneakyThrows
    public void test7(){
        Assertions.assertEquals(adventureService.urlASS("电信五区","乾坤一掷","毒萝"),"https://www.jx3mm.com/home/qyinfo?m=1&R=%E7%94%B5%E4%BF%A1%E4%BA%94%E5%8C%BA&S=%E4%B9%BE%E5%9D%A4%E4%B8%80%E6%8E%B7&t=%E7%BB%9D%E4%B8%96%E5%A5%87%E9%81%87&u=%E4%B8%8D%E9%99%90&n=%E6%AF%92%E8%90%9D&csrf=1650766424965");
        System.out.println(adventureService.urlASS("电信五区","乾坤一掷","毒萝"));
    }
}
