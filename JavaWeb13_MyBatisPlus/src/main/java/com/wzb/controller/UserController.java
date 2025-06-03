package com.wzb.controller;

import com.wzb.pojo.User;
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
        userService.addUser(user);
    }

    @DeleteMapping("/#{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/#{id}")
    public User queryUser(@PathVariable Integer id) {
        return userService.queryUser(id);
    }

    @PostMapping("/batch")
    public List<User> queryBatchUsers(@RequestBody List<Integer> ids) {
        return userService.queryBatchUser(ids);
    }

    @PutMapping("/#{id}/deduction/#{amount}")
    public void updateBalance(@PathVariable Integer id, @PathVariable Integer amount) {
        userService.updateBalance(id, amount);
    }
}
