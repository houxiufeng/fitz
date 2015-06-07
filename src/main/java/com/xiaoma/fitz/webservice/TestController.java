package com.xiaoma.fitz.webservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoma.fitz.domain.Test1;
import com.xiaoma.fitz.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
    private Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestService testService;
    

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findAll(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("tests", testService.findAll());
        return result;
        
    }
    
    @RequestMapping(value = "/page/{curPage}/{perPage}" ,method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> page(@PathVariable Integer curPage, @PathVariable Integer perPage){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("tests", testService.page(curPage, perPage));
        return result;
    }
    
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(){
        Test1 test = new Test1();
        test.setAge(30);
        test.setName("kent");
        testService.save(test);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", 1);
        return result;
    }
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insert(@PathVariable Integer id){
        
        testService.delete(id);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", 1);
        return result;
    }
   
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(){
        Test1 test = new Test1();
        test.setId(1);
        test.setName("ppp");
        testService.update(test);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("status", 1);
        return result;
    }
    
    
    public static void main(String args[]) {
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
        Date date = new Date(1420339489000L);
        System.out.println(date);
    }
}
