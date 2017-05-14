package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6564456371098417836L;

	@Override
	public void init() throws ServletException {
		ServletConfig config = this.getServletConfig();
		String v1 = config.getInitParameter("data1");
		System.out.println("v1: " + v1);
		String v2 = config.getInitParameter("data2");
		System.out.println("v2: " + v2);

		ServletContext ctx = this.getServletContext();
		String globalValue1 = ctx.getInitParameter("globalData1");
		String globalValue2 = ctx.getInitParameter("globalData2");
		System.out.println("global value1: " + globalValue1
				+ ", global value2: " + globalValue2);

		String attribute = (String) ctx.getAttribute("attribute1");
		System.out.println("attribute: " + attribute);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.print("ServletConfig test");
		pw.close();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
