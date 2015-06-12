package com.xiaoma.fitz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.assistant.interceptor.PageControl;
import com.dexcoder.assistant.pager.Pager;
import com.dexcoder.assistant.persistence.JdbcDao;
import com.xiaoma.fitz.domain.User;

@Service
public class UserService {

    @Autowired
    private JdbcDao jdbcDao;
    
    public Pager findAll(int currentPage, int itemsPerPage) {
        PageControl.performPage(currentPage, itemsPerPage);
        jdbcDao.queryList(new User());
        return PageControl.getPager();
        
    }
    
    public void save(User user) {
        jdbcDao.save(user);
    }
}
