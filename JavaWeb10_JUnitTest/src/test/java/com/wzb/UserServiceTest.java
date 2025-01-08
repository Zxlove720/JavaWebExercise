package com.wzb;

import com.wzb.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserServiceTest {

    // @BeforeAll和@AfterAll只能修饰static方法
    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }


    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        Integer age = userService.getAge("100000200410141011");
        System.out.println(age);
    }

    @Test
    public void testGetGender() {
        UserService userService = new UserService();
        String gender = userService.getGender("100000200410141011");
        System.out.println(gender);
    }

    @Test
    public void testGetGenderWithAssert() {
        UserService userService = new UserService();
        String gender = userService.getGender("100000200410141011");
        Assertions.assertEquals("男", gender);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000200410141011", "100000200410141031", "100000200410141051"})
    @DisplayName("断言和参数化测试getGender方法")
    public void testGetGenderWithAssertAndParameterized(String idCard) {
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        Assertions.assertEquals("男", gender);
    }
}
