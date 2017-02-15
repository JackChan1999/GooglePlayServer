package com.google.server;

import org.eclipse.jetty.server.Request;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ============================================================
 * Copyright：${TODO}有限公司版权所有 (c) 2017
 * Author：   陈冠杰
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChen1999
 * 博客：     http://blog.csdn.net/axi295309066
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：GooglePlayServer
 * Package_Name：com.google.server
 * Version：1.0
 * time：2017/2/15 16:05
 * des ：${TODO}
 * gitVersion：$Rev$
 * updateAuthor：$Author$
 * updateDate：$Date$
 * updateDes：${TODO}
 * ============================================================
 **/
public class DefaultHandler extends org.eclipse.jetty.server.handler.DefaultHandler {


	public DefaultHandler() {

	}

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (response.isCommitted() || baseRequest.isHandled())
			return;

		baseRequest.setHandled(true);
		// String method = request.getMethod();//请求方式
		request.getRequestURI();// 请求路径

		System.out.println("URI" + request.getRequestURI());
		System.out.println("URL" + request.getRequestURI());
		response.setStatus(HttpServletResponse.SC_OK);
		// response.setContentType(MimeTypes.TEXT_JSON);
		String str = "我是返回内容";
		byte[] b = str.getBytes();
		response.setContentLength(b.length);
		OutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
	}
}
