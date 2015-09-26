package com.xiaoma.fitz.domain;

import java.util.Date;

import com.xiaoma.fitz.dto.CompanyDto;

public class Company {

    private Integer id;
    private String name;
    private String address;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public void build(CompanyDto dto) {
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.email = dto.getEmail();
        this.createdAt = new Date();
    }
    
}
