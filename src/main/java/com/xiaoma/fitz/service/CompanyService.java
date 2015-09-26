package com.xiaoma.fitz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.assistant.interceptor.PageControl;
import com.dexcoder.assistant.pager.Pager;
import com.dexcoder.assistant.persistence.Criteria;
import com.dexcoder.assistant.persistence.JdbcDao;
import com.xiaoma.fitz.domain.Company;

@Service
public class CompanyService {

    @Autowired
    private JdbcDao jdbcDao;
    
    public Pager findAll(int currentPage, int itemsPerPage) {
        PageControl.performPage(currentPage, itemsPerPage);
        jdbcDao.queryList(new Company());
        return PageControl.getPager();
        
    }
    
    public void save(Company company) {
        jdbcDao.save(company);
    }
    
    public void delete(Integer id) {
        jdbcDao.delete(Company.class, id);
    }
    
    public void update(Company company) {
        Criteria criteria = Criteria.create(Company.class).set("name", company.getName()).set("address", company.getAddress()).set("email", company.getEmail()).where("id", new Object[]{company.getId()});
        jdbcDao.update(criteria);
    }
    
    public Company getById(Integer id) {
        return jdbcDao.get(Company.class, id);
    }
}
