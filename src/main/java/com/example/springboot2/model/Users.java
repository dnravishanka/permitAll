package com.example.springboot2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    private int active;
    private String roles = "";
    private String permissions = "";

    public Users(String userName, String passWord, String roles, String permissions) {
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }

    protected Users() {

    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public List<String> getRollList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissonList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();

    }

}
