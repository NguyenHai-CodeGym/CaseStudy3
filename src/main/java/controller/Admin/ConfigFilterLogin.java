//package controller.Admin;
//
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/dashboard/*")
//public class ConfigFilterLogin implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute("username");
//        if(userName == null){
//            response.sendRedirect("/authentication");
//            return;
//        }
//        filterChain.doFilter(request, response);
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
