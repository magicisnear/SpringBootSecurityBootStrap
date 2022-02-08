package com.SpringBootCrud.JavaMentor.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_users")
public class User implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @Column(name = "age")
    private Long age;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;


    public User() {
    }

    public String getName() {
        return name;
    }


    public User(Long id, String name, String password, Set<Role> roles, Long age, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
        this.age = age;
        this.lastName = lastName;
        this.email = email;
    }

    public User(Long id, String name, String password,Long age, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
