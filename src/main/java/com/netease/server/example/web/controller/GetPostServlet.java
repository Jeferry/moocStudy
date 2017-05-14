package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPostServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8458215303682702068L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name1 = request.getParameter("name1");
		String pw1 = request.getParameter("pw1");

		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("   调用doGet 方法 ");
		out.println("<br></br>");
		out.println("用户名：" + name1);
		out.println("<br></br>");
		out.println("密码:" + pw1);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name2 = request.getParameter("name2");
		String pw2 = request.getParameter("pw2");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    调用doPost 方法 ");
		out.println("<br></br>");
		out.println("用户名:" + name2);
		out.println("<br></br>");
		out.println("密码:" + pw2);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
