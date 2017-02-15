package com.google.servlet;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
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
public class AppServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_OK);
		String path1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "WebInfos/app/applist1";
		String path2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "WebInfos/app/applist2";
		String path3 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "WebInfos/app/applist3";

		String path = null;
		int index = (Integer.valueOf(req.getParameter("index")) / 20) % 3;
		if (index == 0) {
			path = path1;
		} else if (index == 1) {
			path = path2;
		} else {
			path = path3;
		}

		File file = new File(path);
		long length = file.length();
		resp.setContentLength((int) length);
		OutputStream out = resp.getOutputStream();
		FileInputStream stream = new FileInputStream(file);
		int count = -1;
		byte[] buffer = new byte[1024];
		while ((count = stream.read(buffer)) != -1) {
			out.write(buffer, 0, count);
			out.flush();
		}
		stream.close();
		out.close();
	}
}
