package com.SpringBootCrud.JavaMentor.service;

import com.SpringBootCrud.JavaMentor.model.User;

import java.util.List;

public interface UserService {
 User findByID(Long id);
 List<User> getAllUsers();
 User saveUser(User user);
 User findByName(String name);
 void deleteById(Long id);
}
