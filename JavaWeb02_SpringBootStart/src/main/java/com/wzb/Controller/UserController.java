package com.wzb.Controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息Controller
 */
@RestController
public class UserController {

    @RequestMapping("/list")
    public String list() {
        // 1.加载user.txt文件获取用户信息，并将每一行的信息封装到ArrayList集合中，一行信息就是一个字符串元素
        // 因为类和resource在编译之后是在一起的，所以说通过获得本类的类加载器，调用getResourceAsStream方法（参数就是需要的文件名）
        // 返回该文件的输入流，可以避免使用绝对路径获得文件的输入流
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        // 使用hutool中的IoUtil，便捷的读文件输入流的内容，需要指定编码，并返回一个集合，集合中的每一个元素就是文件的一行内容
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        // 2.解析集合，获取用户属性，将属性封装成用户再用集合收集
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(","); // 用","分割字符串，得到每一个属性
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            // 使用DateTimeFormatter类限定时间的格式，并按照该格式将String类型的时间字符串解析为LocalDateTime对象
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());

        //3.响应数据
        // 使用hutool中的JSONUtil类，将集合解析为json字符串返回，还可以使用setDateFormat方法设置json的时间格式
        return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
