package com.wzb;

import com.sun.source.tree.AssertTree;
import com.wzb.Controller.UserController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 使用Junit进行单元测试
 * 1.在pom.xml中引入Junit依赖
 * 2.在test/java的目录下创建测试类，并编写对应的测试方法，并且在方法上声明@Test注解
 */
public class UserTest {
    private final UserController userController = new UserController();


    @Test
    public void testGetGender() {
        String gender = userController.getGender("500104200410141611");
        // 加入assert断言，assert断言的参数都是（不）期望值在前，实际值在后，并且都可以提供报错信息提示
        // 判断两个值是否相等，不相等报错
        Assertions.assertEquals("男", gender); // 男，此处不报
        // 判断两个值是否不相等，相等报错
        Assertions.assertNotEquals("女", gender, "notEquals报错了"); // 男，此处不报
        // 判断实际值是否是null，不是null就报错
        Assertions.assertNull(gender, "null报错了"); // 男，此处报错
        // 判断实际值是否是null，是null就报错
        Assertions.assertNotNull(gender, "notNull报错了"); // 男，此处不报
        // 判断条件值是否为true，不是true就报错
        Assertions.assertTrue(gender.equals("男"), "true报错了"); // 男，此处不报
        // 判断条件之是否为false，不是false就报错
        Assertions.assertFalse(gender.equals("男"), "false报错了"); // 男，此处报错
        // 判断两个对象（引用）是否相等，不相等就报错
        Assertions.assertSame("男", gender, "same报错了"); // 男，此处不报错
    }

}
