package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.IntervieweeImpl;
import com.itheruan.utils.JsonUtil;

@WebServlet("/visitor/likeIntervieweeName")
public class FindIntervieweeNmme extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//接收参数
		String intervieweeNmme = request.getParameter("intervieweeName");
		Map<String, Object> map = new IntervieweeImpl().findByNameInterviewee(intervieweeNmme);
		
		JsonUtil.writeValue(map, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
