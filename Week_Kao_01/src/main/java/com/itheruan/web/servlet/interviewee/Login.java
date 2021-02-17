package com.itheruan.web.servlet.interviewee;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.IntervieweeImpl;

/**
 * 员工登录
 * @author 11137
 *
 */
@WebServlet("/intervieweeId/login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   //判断是否已经登录
        if (request.getSession().getAttribute("manager") != null) {
            //直接跳转到管理页面
            request.getRequestDispatcher("/manage/left.jsp").forward(request, response);
            return;

        }


        // TODO Auto-generated method stub
        //获取用户名和密码
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(id);
        System.out.println(password);

        Map<String, Object> map = new IntervieweeImpl().findByIdPasswordInterviewee(id, password);
        if (map!=null) {
			
		}


        System.out.println(map);
        if (map != null) {
        	//将管理员存入道session域中
            request.getSession().setAttribute("intervieweeMap", map);
            //request.setAttribute("manager", manager);

            //登录成功 重定向后台管理页面
            //request.getRequestDispatcher("/").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/manage/manager/list");

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
