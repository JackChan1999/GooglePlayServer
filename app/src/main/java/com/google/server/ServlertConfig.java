package com.google.server;

import com.google.servlet.AppServlet;
import com.google.servlet.CategoryServlet;
import com.google.servlet.DetailServlet;
import com.google.servlet.DownloadServlet;
import com.google.servlet.GameServlet;
import com.google.servlet.HomeServlet;
import com.google.servlet.HotServlet;
import com.google.servlet.ImageServlet;
import com.google.servlet.RecommendServlet;
import com.google.servlet.SubjectServlet;
import com.google.servlet.UserServlet;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServlertConfig {
	public static void config(ServletContextHandler handler) {
		handler.addServlet(new ServletHolder(new CategoryServlet()), "/category");
		handler.addServlet(new ServletHolder(new ImageServlet()), "/image");
		handler.addServlet(new ServletHolder(new RecommendServlet()), "/recommend");
		handler.addServlet(new ServletHolder(new SubjectServlet()), "/subject");
		handler.addServlet(new ServletHolder(new DetailServlet()), "/detail");
		handler.addServlet(new ServletHolder(new HomeServlet()), "/home");
		handler.addServlet(new ServletHolder(new AppServlet()), "/app");
		handler.addServlet(new ServletHolder(new GameServlet()), "/game");
		handler.addServlet(new ServletHolder(new DownloadServlet()), "/download");
		handler.addServlet(new ServletHolder(new UserServlet()), "/user");
		handler.addServlet(new ServletHolder(new HotServlet()), "/hot");
	}
}
