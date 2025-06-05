package com.wzb.controller;

import com.wzb.pojo.User;
import com.wzb.pojo.UserQuery;
import com.wzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
    }

    @GetMapping("/{id}")
    public User queryUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> queryBatchUsers(@RequestParam("ids") List<Integer> ids) {
        return userService.listByIds(ids);
    }

    @GetMapping("/page")
    public List<User> pageQuery(UserQuery userQuery) {
        return userService.pageQuery(userQuery);
    }

    @PutMapping("/{id}/deduction/{amount}")
    public void updateBalance(@PathVariable Integer id, @PathVariable Integer amount) {
        userService.updateBalance(id, amount);
    }

    @PostMapping("/query")
    public List<User> conditionQuery(@RequestBody UserQuery userQuery) {
        return userService.conditionQuery(userQuery);
    }
}
