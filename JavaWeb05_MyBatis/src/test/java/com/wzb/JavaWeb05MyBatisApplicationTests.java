package com.wzb;

import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
// 这是SpringBoot框架中的单元测试注解，当测试类的测试方法运行时，就会启动SpringBoot项目
// SpringBoot项目启动了，IOC容器就创建好了，若想测试IOC容器中的bean就可以直接注入了
class JavaWeb05MyBatisApplicationTests {

    private final UserMapper userMapper;

    @Autowired
    public JavaWeb05MyBatisApplicationTests (UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testSelectAll() {
        List<User> userList = userMapper.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDelete() {
        Integer rows = userMapper.deleteById(5);
        System.out.println("影响的行数是：" + rows);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "zhouyu", "123456", "周瑜", 23);
        Integer rows = userMapper.insertUser(user);
        System.out.println("影响的行数是：" + rows);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, "liubei", "123456", "刘备", 25);
        Integer rows = userMapper.updateUser(user);
        System.out.println("影响的行数是：" + rows);
    }

    @Test
    public void testFind() {
        User user = userMapper.selectUser("liubei", "123456");
        System.out.println(user);
    }
}
