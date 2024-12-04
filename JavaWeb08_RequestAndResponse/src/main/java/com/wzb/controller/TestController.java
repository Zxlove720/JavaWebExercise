package com.wzb.controller;

import com.wzb.pojo.Address;
import com.wzb.pojo.TestUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @RequestMapping("/simple")
//    public String getSimpleParameter(HttpServletRequest httpServletRequest) {
//        String name = httpServletRequest.getParameter("name");
//        // 通过HttpServletRequest对象获取的请求参数都是String类型的，需要手动进行类型转换
//        int age = Integer.parseInt(httpServletRequest.getParameter("age"));
//        System.out.println("姓名是: " + name + "年龄是: " + age);
//        return "hello " + name + age;
//    }

//    @RequestMapping("/simple")
//    public String getSimpleParameter(@RequestParam(name="name", required = false) String username, int age) {
//        System.out.println("姓名是: " + username + "年龄是: " + age);
//        return "hello " + username + age;
//    }

//    @RequestMapping("/complex")
//    public String getSimpleParameter(TestUser user) {
//        String name = user.getName();
//        int age = user.getAge();
//        System.out.println("姓名是: " + name + "年龄是: " + age);
//        System.out.println(user);
//        return "hello " + name + age;
//    }


//    @RequestMapping("/complexPojo")
//    public String getComplexParameter(TestUser user) {
//        String name = user.getName();
//        int age = user.getAge();
//        Address address = user.getAddress();
//        System.out.println("姓名是: " + name + "年龄是: " + age + "地址是: " + address.getProvince() + " " + address.getCity());
//        System.out.println(user);
//        return "hello " + name + age + address;
//    }


    @RequestMapping("/hobbies")
    public String getArrayParameter(String[] hobby) {
        for (String hobbies : hobby) {
            System.out.println(hobbies);
        }
        return "successful";
    }
}
