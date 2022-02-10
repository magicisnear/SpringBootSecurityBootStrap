package com.SpringBootCrud.JavaMentor.service;

import com.SpringBootCrud.JavaMentor.repository.RoleRepository;
import com.SpringBootCrud.JavaMentor.repository.UserRepository;
import com.SpringBootCrud.JavaMentor.model.Role;
import com.SpringBootCrud.JavaMentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findByID(Long id) {
       return userRepository.findById(id).get();
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


    @Transactional
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByUserNameAndFetchRoles(name);
    }

    @Override
    public List<User> getAllUsersAndFetchRoles() {
        return userRepository.findAll();
    }

    public List<Role> listRoles() {
        List<Role> roleList = roleRepository.findAll();
        Set<Role> s = new LinkedHashSet<>(roleList);
        roleList.clear();
        roleList.addAll(s);
        return roleList;
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}


