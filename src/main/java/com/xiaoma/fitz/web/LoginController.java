package com.xiaoma.fitz.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoma.fitz.domain.User;
import com.xiaoma.fitz.dto.LoginDto;
import com.xiaoma.fitz.service.UserService;
import com.xiaoma.fitz.utils.Fitz;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(LoginDto loginDto, HttpSession session) {
        User user = userService.findByNameAndPwd(loginDto.getUserName(), loginDto.getPassword());
        String location = "redirect:/app/main";
        if(null != user) {
            session.setAttribute(Fitz.CURRENT_USER, user);
        } else {
            location = "login";
        }
        return location;
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value="/app/main", method = RequestMethod.GET)
    public String main(HttpSession session, Model model) {
        model.addAttribute("currentUser", session.getAttribute(Fitz.CURRENT_USER));
        return "main";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(Fitz.CURRENT_USER);
        return "redirect:/login";
    }
}
