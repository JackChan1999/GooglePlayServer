package com.google.server;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.mortbay.ijetty.log.AndroidLog;
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
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private Button mBtStart, mBtStop, mBtSetting;
	//	public static final File JETTY_DIR;
	//	public static final String WEBAPP_DIR = "webapps";
	//	public static final String ETC_DIR = "etc";
	//	public static final String CONTEXTS_DIR = "contexts";
	//
	static {
		// 不使用jetty的XML解析验证
		System.setProperty("org.eclipse.jetty.xml.XmlParser.Validating", "false");
		// 使用android日志类
		System.setProperty("org.eclipse.jetty.util.log.class", "org.mortbay.ijetty.AndroidLog");
		org.eclipse.jetty.util.log.Log.setLog(new AndroidLog());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mBtStart = (Button) findViewById(R.id.bt_start);
		mBtStop = (Button) findViewById(R.id.bt_stop);
		mBtSetting = (Button) findViewById(R.id.bt_setting);
		mBtStart.setOnClickListener(this);
		mBtStop.setOnClickListener(this);
		mBtSetting.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.bt_start:
				onStartClick();
				break;
			case R.id.bt_stop:
				onStopClick();
				break;
			case R.id.bt_setting:
				onSettingClick();
				break;
		}
	}

	public void onStartClick() {
		Intent intent = new Intent(this, WebService.class);
		startService(intent);
	}

	public void onStopClick() {
		Intent intent = new Intent(this, WebService.class);
		stopService(intent);
	}

	public void onSettingClick() {

	}
}
