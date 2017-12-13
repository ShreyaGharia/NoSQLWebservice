package com.target.myRetail.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by Shreya on 12/12/2017.
 */
@Document(collection = "user")
public class User {

    @Id
    private String userId;
    private String username;
    private String password;

    @DBRef
    private List<Roles> rolesList;

    public User(String userId, String username, String password, List<Roles> rolesList) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.rolesList = rolesList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }
}
