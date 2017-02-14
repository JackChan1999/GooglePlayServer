package com.google.server;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.io.File;


public class WebService extends Service {
	private final int open_server = 0;
	private final int open_server_fail = 1;
	private final int close_server = 2;
	private final int close_server_fail = 3;

	private Server server;

	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			String text = null;
			switch (msg.what){
				case open_server:
					text = "服务器启动";
					break;
				case open_server_fail:
					text = "服务器启动失败";
					break;
				case close_server:
					text = "服务器关闭";
					break;
				case close_server_fail:
					text = "服务器关闭失败";
					break;
			}
			Toast.makeText(WebService.this, text, Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startForeground(9999, new Notification());
		startServer();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		stopServer();
		super.onDestroy();
	}

	private void startServer() {
		if (server != null) {
			Toast.makeText(this, "服务器已经开启", Toast.LENGTH_SHORT).show();
			return;
		}
		new Thread(new StartRunnable()).start();
	}

	private void stopServer() {
		if (server != null) {
			new Thread(new StopRunnable()).start();
		}
	}

	class StartRunnable implements Runnable {
		@Override
		public void run() {
			try {
				File JETTY_DIR = new File(Environment.getExternalStorageDirectory(), "jetty");
				// Set jetty.home
				System.setProperty("jetty.home", JETTY_DIR.getAbsolutePath());

				// ipv6 workaround for froyo
				System.setProperty("java.net.preferIPv6Addresses", "false");

				server = new Server(8090);
				// server.setHandler(new DefaultHandler());
				ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
				contextHandler.setContextPath("/");
				server.setHandler(contextHandler);
				ServlertConfig.config(contextHandler);

				server.start();
				server.join();

				mHandler.sendEmptyMessage(open_server);
			} catch (Exception e) {
				server = null;
				e.printStackTrace();
				System.out.println("Exception");
				mHandler.sendEmptyMessage(open_server_fail);
			}
		}
	}

	class StopRunnable implements Runnable {
		@Override
		public void run() {
			try {
				server.stop();
				server = null;
				mHandler.sendEmptyMessage(close_server);
			} catch (Exception e) {
				e.printStackTrace();
				mHandler.sendEmptyMessage(close_server_fail);
			}
		}
	}
}
