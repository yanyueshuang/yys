package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.IntervieweeImpl;

/**
 * 查询所有受访者
 * @author 11137
 *
 */
@WebServlet("/visitor/listVisitor")
public class ListVisitor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				List<Map<String,Object>> intervieweeList = new IntervieweeImpl().findAllInterviewee();
				
				request.setAttribute("intervieweeList", intervieweeList);
				//跳转展示页面
				request.getRequestDispatcher("/visitorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
