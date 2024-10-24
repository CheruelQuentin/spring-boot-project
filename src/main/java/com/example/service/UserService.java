package com.example.service;

import com.example.data.UserTable;
import com.example.data.UserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserTable> findAllUsers() {
        List<UserTable> userTables = new ArrayList<>();
        Iterable<UserTable> lists = userRepository.findAll();
        lists.forEach(userTables::add);
        return userTables;
    }

    public UserTable findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Collection<UserTable> findUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public void addUser(UserTable userTable) {
        System.out.println("User added");
        System.out.println(userTable.getFirstName() + " " + userTable.getLastName() + " added.");
        userRepository.save(userTable);
    }

    public void updateUser(UserTable userTable) {
        Optional<UserTable> oldUser = userRepository.findById(userTable.getId());
        if (oldUser.isPresent()) {
            userRepository.save(userTable);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    // MVC Version
    public List<UserTable> getAllUsers() {
        List<UserTable> userTables = new ArrayList<>();
        userTables.add(new UserTable("John", "Doe"));
        userTables.add(new UserTable("Jane", "Doe"));
        userTables.add(new UserTable("Jean", "Phillipe"));
        return userTables;
    }
}
