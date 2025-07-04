package com.wzb.controller;

import com.wzb.pojo.User;
import com.wzb.pojo.UserQuery;
import com.wzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户Controller
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        System.out.println();
        userService.save(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
    }

    /**
     * 查询用户
     *
     * @param id 用户id
     * @return User用户实体
     */
    @GetMapping("/{id}")
    public User queryUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    /**
     * 批量查询用户
     *
     * @param ids id集合
     * @return List<User> 用户列表
     */
    @GetMapping
    public List<User> queryBatchUsers(@RequestParam("ids") List<Integer> ids) {
        return userService.listByIds(ids);
    }

    /**
     * 分页查询
     *
     * @param userQuery 用户查询实体类
     * @return List<User> 用户列表
     */
    @GetMapping("/page")
    public List<User> pageQuery(UserQuery userQuery) {
        return userService.pageQuery(userQuery);
    }

    /**
     * 修改用户余额
     *
     * @param id 用户id
     * @param amount 修改的金额
     */
    @PutMapping("/{id}/deduction/{amount}")
    public void updateBalance(@PathVariable Integer id, @PathVariable Integer amount) {
        userService.updateBalance(id, amount);
    }

    /**
     * 条件查询
     *
     * @param userQuery 用户查询实体
     * @return List<User> 用户列表
     */
    @PostMapping("/query")
    public List<User> conditionQuery(@RequestBody UserQuery userQuery) {
        return userService.conditionQuery(userQuery);
    }
}
