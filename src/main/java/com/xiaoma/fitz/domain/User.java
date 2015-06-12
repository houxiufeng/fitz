package com.xiaoma.fitz.domain;

import java.util.Date;

import com.xiaoma.fitz.dto.UserDto;

public class User {

    private Integer id;
    private String avatar;
    private String name;
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
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    public void build(UserDto dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
    }
    
}
