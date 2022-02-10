package com.SpringBootCrud.JavaMentor.service;

import com.SpringBootCrud.JavaMentor.model.Role;
import com.SpringBootCrud.JavaMentor.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
