package com.xiaoma.fitz.domain;

import java.util.Date;

import com.xiaoma.fitz.dto.UserDto;

public class User {

    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String email;
    private Date createdAt;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void build(UserDto dto) {
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.age = dto.getAge();
        this.email = dto.getEmail();
        this.createdAt = new Date();
    }
    
}
