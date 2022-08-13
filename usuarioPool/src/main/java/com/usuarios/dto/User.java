package com.usuarios.dto;

import java.util.Date;

public class User {
    private Long id;
    private String User;
    private String password;
    private Date date;

    public User(){}

    public User(Long id, String user, String password, Date date) {
        this.id = id;
        User = user;
        this.password = password;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User --> " +
                "id=" + id +
                ", User=" + User  +
                ", password=" + password  +
                ", date=" + date ;
    }
}
