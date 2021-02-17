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
 * 添加访客
 * @author 11137
 *
 */
@WebServlet("/visitor/addVisitor")
public class AddVisitor extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				String company = request.getParameter("company");
				String phone = request.getParameter("phone");
				System.out.println(sex);
				new VisitorImpl().saveVisitor(name,sex,company,phone);
				
				//跳转页面
				request.getRequestDispatcher("/visitorLogin.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
