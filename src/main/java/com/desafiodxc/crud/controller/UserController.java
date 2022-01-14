package com.desafiodxc.crud.controller;

import java.util.List;

import com.desafiodxc.crud.model.UserModel;
import com.desafiodxc.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserModel create(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List <UserModel> list() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserModel show(@PathVariable Long id) {
        return userService.findUserById(id).get();
    }

    @PutMapping(value = "/{id}")
    public UserModel update(@PathVariable(value="id") Long id,@RequestBody UserModel user){
        return userService.updateByUser(id,user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value="id") Long user) {
        userService.deleteUserById(user);
    }
}