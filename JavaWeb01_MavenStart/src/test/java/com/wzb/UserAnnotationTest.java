package com.wzb;

import com.wzb.Controller.UserController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Junit其他注解
 */
public class UserAnnotationTest {
    private UserController userController;

    @BeforeAll // 使用@BeforeAll注解的方法必须是static方法
    public static void showBefore() {
        System.out.println("before all");
    }

    @BeforeEach
    public void createUser() {
        System.out.println("before each");
        userController = new UserController();
    }

    @DisplayName("测试性别男：正常输入身份证")
    @ParameterizedTest
    @ValueSource(strings = {"123456789987654311", "147852369963258731", "321456987789654153"})
    public void testGenderMan(String id) {
        String gender = userController.getGender(id);
        Assertions.assertEquals("男", gender);
    }

    @DisplayName("测试性别女：正常输入身份证")
    @ParameterizedTest
    @ValueSource(strings = {"123456789987654301", "147852369963258741", "321456987789654183"})
    public void testGenderWoman(String id) {
        String gender = userController.getGender(id);
        Assertions.assertEquals("女", gender);
    }

    @DisplayName("测试性别男：输入错误身份证")
    @ParameterizedTest
    @ValueSource(strings = {"12354311", "147852731", "4153", ""})
    public void testGender(String id) {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            userController.getGender(id);
        });
    }

    @AfterEach
    public void clean() {
        System.out.println("afterEach");
    }

    @AfterAll
    public static void showAfter() {
        System.out.println("after all");
    }




}
