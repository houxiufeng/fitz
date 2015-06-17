package com.xiaoma.fitz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.assistant.interceptor.PageControl;
import com.dexcoder.assistant.pager.Pager;
import com.dexcoder.assistant.persistence.Criteria;
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
    
    public void delete(Integer id) {
        jdbcDao.delete(User.class, id);
    }
    
    public void update(User user) {
    	Criteria criteria = Criteria.create(User.class).set("name", user.getName()).set("age", user.getAge())
    	        .set("email", user.getEmail()).set("password", user.getPassword()).where("id", new Object[]{user.getId()});
        jdbcDao.update(criteria);
    }
    
    public User getById(Integer id) {
        return jdbcDao.get(User.class, id);
    }
    
    public User findByNameAndPwd(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return jdbcDao.querySingleResult(user);
    }
}
