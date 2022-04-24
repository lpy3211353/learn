package com.lpy.demo.service.raw;

import com.alibaba.fastjson.JSONObject;
import com.lpy.demo.entity.ComputerClass;
import com.lpy.demo.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassTest {
    @Test
    void test(){
        ComputerClass computerClass = new ComputerClass();
        computerClass.setClassName("jsj");
        List<Student> list = new ArrayList<>(10);
        list.add(new Student("lpy",18));
        list.add(new Student("ypl",19));
        list.add(new Student("ypl",20));
        computerClass.setStudents(list);
        List<Student> list1 = computerClass.getStudents();
        list1.add(new Student("aaa",30));
        list1.add(Student.builder().name("fff").age(666).build());
        Assertions.assertEquals(list1,computerClass.getStudents());
        String s = JSONObject.toJSONString(computerClass);
        System.out.println(s);
    }
}
