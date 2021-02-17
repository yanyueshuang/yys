package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.VisitorImpl;

/**
 * 访客登录
 * @author 11137
 *
 */
@WebServlet("/visitor/visitorLogin")
public class LoginVisitor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println(name);
		System.out.println(phone);
		Map<String, Object> visitor = new VisitorImpl().findByIdPasswordVisitor(name, phone);
		  if (visitor != null) {
	        	//将访问者存入道session域中
	            request.getSession().setAttribute("visitor", visitor);
	            //request.setAttribute("manager", manager);

	            //登录成功 重定向后台管理页面
	            //request.getRequestDispatcher("/").forward(request, response);
	            //response.sendRedirect(request.getContextPath() + "/visitor/listVisitort");
	            request.getRequestDispatcher("/visitor/listVisitor").forward(request, response);
	        } else {
	
	        	//登录失败
	            //跳转失败页面
	            request.setAttribute("error", "您的用户名或密码错误，请重试");
	            request.getRequestDispatcher("/error.jsp").forward(request, response);

	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
