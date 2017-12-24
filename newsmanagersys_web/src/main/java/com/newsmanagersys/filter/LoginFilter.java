package com.newsmanagersys.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录过滤器
 */
public class LoginFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response=(HttpServletResponse)arg1;
        HttpSession session = request.getSession();

        //获取用户请求的url
        String path = request.getRequestURI();
        //从session取得已经登录验证的凭证，根据对象来验证
        Object LoginUser = (Object) session.getAttribute("LoginUser");

        if(path.indexOf("userlogin.jsp")>-1){ //如果是login.jsp这个页面不需要过滤
            arg2.doFilter(request,response);
            return;
        }else{      //如果不是login.jsp就进行过滤
            if(LoginUser==null){
                //跳转到登录页面
                response.sendRedirect(request.getContextPath()+"/pages/userlogin.jsp");
            }else{
                //已经登录，继续请求
                arg2.doFilter(request,response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }




}
