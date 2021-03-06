package com.xiaoma.fitz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dexcoder.assistant.pager.Pager;
import com.xiaoma.fitz.domain.User;
import com.xiaoma.fitz.dto.PageDto;
import com.xiaoma.fitz.dto.UserDto;
import com.xiaoma.fitz.service.UserService;

@Controller
@RequestMapping("/app/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String loadData(PageDto pageDto, Model model){
        Pager pager = userService.findAll(pageDto.getCurrentPage(), pageDto.getItemsPerPage());
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        
        return "/user/index";
    } 
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model){
        return "/user/new";
    } 
    
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(UserDto userDto, Model model){
        User user = new User();
        user.build(userDto);
        userService.save(user);
        Pager pager = userService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/user/index";
    } 
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "/user/edit";
    } 
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(User user, Model model){
        userService.update(user);
        Pager pager = userService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/user/index";
    } 
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id, Model model){
        userService.delete(id);
        Pager pager = userService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/user/index";
    } 
}
