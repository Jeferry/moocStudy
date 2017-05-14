package com.netease.server.example.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4949269477839398532L;

	@Override
	public void init() throws ServletException {
		System.out.println("init /hello/world");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service method");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet method");
		PrintWriter pw = resp.getWriter();
		pw.print("/hello/world/*");
		pw.close();
	}
}
