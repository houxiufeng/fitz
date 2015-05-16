package com.xiaoma.test;

import java.util.Date;

import com.dexcoder.assistant.pager.Pageable;

public class Test1 extends Pageable {

    private Integer id;

    private String  name;

    private Integer age;

    private Date    createdAt;

    private Date    updatedAt;
    
    private Integer userGradeId;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserGradeId() {
        return userGradeId;
    }

    public void setUserGradeId(Integer userGradeId) {
        this.userGradeId = userGradeId;
    }
    
    

}
