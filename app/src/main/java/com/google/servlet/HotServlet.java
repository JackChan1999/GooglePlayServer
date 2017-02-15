package com.google.servlet;

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
public class HotServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(HttpServletResponse.SC_OK);
		String strResponse = "['QQ','视频','放开那三国','电子书','酒店','单机','小说','斗地主','优酷','网游','WIFI万能钥匙','播放器','捕鱼达人2','机票','游戏','熊出没之熊大快跑','美图秀秀','浏览器','单机游戏','我的世界','电影电视','QQ空间','旅游','免费游戏','2048','刀塔传奇','壁纸','节奏大师','锁屏','装机必备','天天动听','备份','网盘','海淘网','大众点评','爱奇艺视频','腾讯手机管家','百度地图','猎豹清理大师','谷歌地图','hao123上网导航','京东','youni有你','万年历-农历黄历','支付宝钱包']";
		byte[] b = strResponse.getBytes();
		resp.setContentLength(b.length);
		OutputStream out = resp.getOutputStream();
		out.write(b);
		out.close();
	}
}
