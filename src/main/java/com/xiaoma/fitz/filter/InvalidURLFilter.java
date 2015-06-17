package com.xiaoma.fitz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoma.fitz.utils.Fitz;


public class InvalidURLFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res  =(HttpServletResponse) arg1;
        String[] noFilters = new String[] { "/something" };
        String contextPath = req.getContextPath();
        String uri = req.getRequestURI();
        boolean dofilter = true;
        for(String noFilter: noFilters){
            if(uri.indexOf(noFilter) != -1){
               dofilter = false; 
            }
        }
        if(dofilter){
            if(req.getSession().getAttribute(Fitz.CURRENT_USER) == null) {
                res.sendRedirect(contextPath + "/login");
                return;
            }
        }
        System.out.println(uri);
        chain.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

}
