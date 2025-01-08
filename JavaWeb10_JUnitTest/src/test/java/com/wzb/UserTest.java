package com.wzb;

import com.wzb.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * 用户测试类
 */
public class UserTest {
    private UserService userService;

    /**
     * 每一个测试方法运行前，都自动创建一个UserService对象
     */
    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("获取性别：null")
    public void testGetGenderWithNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new NamedExecutable() {
            @Override
            public void execute() throws Throwable {
                userService.getGender(null);
            }
        });
    }

    @Test
    @DisplayName("获取性别：空串")
    public void testGetGenderWithEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, new NamedExecutable() {
            @Override
            public void execute() throws Throwable {
                userService.getGender("");
            }
        });
    }

    @Test
    @DisplayName("获取性别，长度不足")
    public void testGetGenderWithShort() {
        Assertions.assertThrows(IllegalArgumentException.class, new NamedExecutable() {
            @Override
            public void execute() throws Throwable {
                userService.getGender("1000002004101");
            }
        });
    }

    @Test
    @DisplayName("获取性别，长度过长")
    public void testGetGenderWithLong() {
        Assertions.assertThrows(IllegalArgumentException.class, new NamedExecutable() {
            @Override
            public void execute() throws Throwable {
                userService.getGender("1000002004101410110000000");
            }
        });
    }

    @DisplayName("获取性别：男")
    @ParameterizedTest
    @ValueSource(strings = {"100000200410141011", "100000200410141031", "100000200410141051"})
    public void testGetGenderWithMan(String idCard) {
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男", gender);
    }

    @DisplayName("获取性别：女")
    @ParameterizedTest
    @ValueSource(strings = {"100000200410141021", "100000200410141041", "100000200410141061"})
    public void testGetGenderWithWoman(String idCard) {
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("女", gender);
    }

    @AfterAll
    public static void end() {
        System.out.println("测试完毕");
    }
}
