package com.example.web;

import com.example.data.UserTable;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //Version MVC
    // private final UserService userService;
    // public UserController(UserService personService) {
    //     this.userService = personService;
    // }

    // @GetMapping("/users")
    // public String getUsers(Model model) {
    //     model.addAttribute("users", userService.getAllUsers());
    //     return "UserView.html";
    // }

    // Version REST
    // @GetMapping("/users")
    // public List<User> getUsers() {
    //     return userService.getAllUsers();
    // }

    // Version bdd JPA
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserTable> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping
    public void addUser(@RequestBody UserTable userTable) {
        userService.addUser(userTable);
    }

    @GetMapping(path = "{id}")
    public UserTable getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping
    public void updateUser(@RequestBody UserTable userTable) {
        userService.updateUser(userTable);
    }

}
