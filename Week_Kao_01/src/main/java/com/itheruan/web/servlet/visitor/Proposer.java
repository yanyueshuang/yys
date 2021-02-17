package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.ZhongImpl;

/**
 * 申请访问
 */
@WebServlet("/visitor/proposer")
public class Proposer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String visitorId = request.getParameter("visitorId");
		String intervieweeId = request.getParameter("intervieweeId");
		System.out.println(visitorId);
		System.out.println(intervieweeId);
		new ZhongImpl().saveZhong(intervieweeId, visitorId, new Date(),"申请中");
		
		//跳转访问者申请单
		request.getRequestDispatcher("/visitor/stateVisitory").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
