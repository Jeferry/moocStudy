package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 *
 */
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 4607606190625660785L;

    /**
     * Logger for this class.
     */
    private static Logger logger = Logger.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        login(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        logger.info("UserServlet post method is invoked.");
        response.setContentType("text/html;charset=UTF-8");
        login(request, response);
    }

    /**
     * 1、从请求中获取登录用户的用户名和密码；两个字段都是字符串类型，名称分别为user和password；
     * 2、第一次登录时分别创建cookie和session；其中cookie保存用户名，session保存密码；设置cookie的有效期为30分钟；
     * 3、后面登录时（除第一次登录外）；调用api使得session失效；检查请求中cookie的用户名的值是否和当前的用户名是否一致，如果不一致则打印出当前请求的用户名；
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        //从请求中获取user和password
        String user = request.getParameter("user");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        String pwd = (String) session.getAttribute("password");

        if (pwd != null) {
            //再次登录，使得session失效
            if (session != null) {
                session.invalidate();
                System.out.println("session has already been invalidated!");
            }
            //从cookie中获取user
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        user = cookie.getValue();
                        break;
                    }
                }
            }
        } else {
            //第一次登录，设置session，保存密码
            session.setAttribute("password", password);
            //设置cookie，保存用户
            Cookie userNameCookie = new Cookie("user", user);
            //设置cookie的有效期为30分钟
            userNameCookie.setMaxAge(30 * 60);

            response.addCookie(userNameCookie);
        }

        try {
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head><title>用户中心</title></head>");
            writer.println("<body>");
            //检查请求中cookie的用户名的值是否和当前的用户名是否一致，如果不一致则打印出当前请求的用户名
            if (!StringUtils.equals(user, "123")) {
                writer.println("<p>login：failed!</p>");
                writer.println("<p>用户名：" + user + "</p>");
            } else {
                writer.println("<p>login：success!</p>");
            }
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            dispatcher = request.getRequestDispatcher("/error.html");
            dispatcher.forward(request, response);
        }

    }
}
