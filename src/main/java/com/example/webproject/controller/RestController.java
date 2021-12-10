package com.example.webproject.controller;

import com.example.webproject.model.UserModel;
import com.example.webproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(value = "*")
public class RestController {
    @Autowired
    private UserService service;

    @PostMapping("/save-user")
    @Transactional

    public String registeruser(@RequestBody UserModel userModel) {
        service.saveMyUser(userModel);
        return "Hello " + userModel.getFirstname() + ", your registration is successful";
    }

    @GetMapping("/all-users")
    public Iterable<UserModel> showAllUsers() {
        return service.showAllUsers();
    }
    @DeleteMapping("/delete/{username}")
    @CrossOrigin()
    @Transactional
    public Iterable<UserModel> deleteUser(@PathVariable String username)
    {
        return service.deleteUserByUsername(username);
    }
    @GetMapping("search/{username}")
    public UserModel searchUser(@PathVariable String username){
        return service.findByUsername(username);
    }
}
