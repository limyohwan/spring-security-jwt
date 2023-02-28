package org.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if("POST".equals(req.getMethod())){
            System.out.println("post요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);

            if("yhlim".equals(headerAuth)){
                chain.doFilter(request,response);
            }else{
                PrintWriter out = res.getWriter();
                out.println("no auth");
            }
        }

        System.out.println("filter3입니다");

    }
}
