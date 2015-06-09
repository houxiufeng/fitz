package com.xiaoma.fitz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dexcoder.assistant.pager.Pager;
import com.xiaoma.fitz.dto.PageDto;
import com.xiaoma.fitz.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String loadData(PageDto pageDto, Model model){
        Pager pager = userService.findAll(pageDto.getCurrentPage(), pageDto.getItemsPerPage());
        model.addAttribute("records", pager.getList());
        model.addAttribute("total", pager.getItemsTotal());
        model.addAttribute("begin", pager.getBeginIndex());
        model.addAttribute("end", pager.getEndIndex());
        model.addAttribute("pages",pager.getSlider());
        model.addAttribute("currentPage", pager.getCurPage());
        return "/user/index";
    } 
}
