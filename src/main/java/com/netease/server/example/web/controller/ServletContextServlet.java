package com.netease.server.example.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netease.server.example.util.GeneralUtil;

public class ServletContextServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663788316434044740L;

	@Override
	public void init() throws ServletException {
		ServletContext ctx = this.getServletContext();
		String globalValue1 = ctx.getInitParameter("globalData1");
		String globalValue2 = ctx.getInitParameter("globalData2");
		System.out.println("servlet context global value1: " + globalValue1
				+ ", global value2: " + globalValue2);
		ctx.setAttribute("attribute1", "111");

		try {
			URL url = ctx.getResource("/WEB-INF/classes/log4j.properties");
			InputStream in = url.openStream();
			String propertyValue = GeneralUtil.getPropery("log4j.rootLogger",
					in);
			System.out.println("property value: " + propertyValue);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=======================================");
		InputStream in2 = ctx
				.getResourceAsStream("/WEB-INF/classes/log4j.properties");
		String p2 = GeneralUtil.getPropery("log4j.rootLogger", in2);
		System.out.println("p2: " + p2);
		System.out.println("=======================================");
		String path = ctx.getRealPath("/WEB-INF/classes/log4j.properties");
		System.out.println("real path: " + path);
		File f = new File(path);
		try {
			InputStream in3 = new FileInputStream(f);
			String p3 = GeneralUtil.getPropery("log4j.rootLogger", in3);
			System.out.println("p3: " + p3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.print("ServletContext test");
		pw.close();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

}
