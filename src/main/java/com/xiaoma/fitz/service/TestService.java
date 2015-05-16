package com.xiaoma.fitz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.assistant.interceptor.PageControl;
import com.dexcoder.assistant.pager.Pager;
import com.dexcoder.assistant.persistence.JdbcDao;
import com.xiaoma.fitz.domain.Test1;

@Service
public class TestService {

    @Autowired
    private JdbcDao jdbcDao;
    
    public List<Test1> findAll() {
        return jdbcDao.queryList(new Test1());
    }
    
    public void save(Test1 test) {
        jdbcDao.save(test);
    }
    
    public void update(Test1 test) {
        jdbcDao.update(test);
    }
    
    public void delete(int id) {
        jdbcDao.delete(Test1.class, id);
    }
    
    public List<Test1> page(int curPage, int perPage) {
        PageControl.performPage(curPage, perPage);
        jdbcDao.queryList(new Test1());
        Pager p = PageControl.getPager();
        List<Test1> lists = p.getList(Test1.class);
        for (Test1 item : lists) {
            System.out.println(item.getName() + item.getAge());
        }
        System.out.println(p.getItemsTotal());
        return lists;
        
    }
}
