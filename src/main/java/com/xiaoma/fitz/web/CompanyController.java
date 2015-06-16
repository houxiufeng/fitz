package com.xiaoma.fitz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dexcoder.assistant.pager.Pager;
import com.xiaoma.fitz.domain.Company;
import com.xiaoma.fitz.dto.PageDto;
import com.xiaoma.fitz.dto.CompanyDto;
import com.xiaoma.fitz.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String loadData(PageDto pageDto, Model model){
        Pager pager = companyService.findAll(pageDto.getCurrentPage(), pageDto.getItemsPerPage());
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        
        return "/company/index";
    } 
    
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model){
        return "/company/new";
    } 
    
    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(CompanyDto companyDto, Model model){
        Company company = new Company();
        company.build(companyDto);
        companyService.save(company);
        Pager pager = companyService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/company/index";
    } 
    
    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("company", companyService.getById(id));
        return "/company/edit";
    } 
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String update(Company company, Model model){
        companyService.update(company);
        Pager pager = companyService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/company/index";
    } 
    
    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Integer id, Model model){
        companyService.delete(id);
        Pager pager = companyService.findAll(1, 20);
        model.addAttribute("pager",pager);
        model.addAttribute("slider",pager.getSlider());
        return "/company/index";
    }
}