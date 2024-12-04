package com.wzb.controller;

import com.wzb.pojo.Address;
import com.wzb.pojo.TestUser;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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


//    @RequestMapping("/hobbies")
//    public String getArrayParameter(String[] hobby) {
//        for (String hobbies : hobby) {
//            System.out.println(hobbies);
//        }
//        return "successful";
//    }

    @RequestMapping("/listParameter")
    public String getListParameter(@RequestParam(name = "hobby") List<String> hobbyss) {
        for (String s : hobbyss) {
            System.out.println(s);
        }
        System.out.println("用集合成功接收数组参数");
        return "successful";
    }


    @RequestMapping("/date")
    public String getDateParameter(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime times) {
        System.out.println(times);
        return "现在时间是" + times;
    }

    @RequestMapping("/Json")
    public String getJsonParameter(@RequestBody TestUser user) {
        System.out.println(user);
        return "Json数据接收成功" + user;
    }

    @RequestMapping("/path/{id}")
    public String getPathParameter(@PathVariable int id) {
        System.out.println("成功获取路径参数：" + id);
        return "successful";
    }

    @RequestMapping("/path/{id}/{name}")
    public String getManyPathParameter(@PathVariable int id, @PathVariable String name) {
        System.out.println("成功获取多个路径参数：" + id + "   " + name);
        return "successful";
    }
}
