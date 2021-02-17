package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheruan.dao.impl.ZhongImpl;

/**
 * 该访问者申请单
 * @author 11137
 *
 */
@WebServlet("/visitor/stateVisitory")
public class StateVisitory extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					//获取session中的访问者
		Map<String, Object>  visitor = (Map<String, Object>) request.getSession().getAttribute("visitor");
		//获取id
		Integer visitorId = (Integer) visitor.get("visitor_id");
		System.out.println(visitor);
		
		List<Map<String, Object>> zhongList = new ZhongImpl().findByVisitorIdZhong(visitorId);
		
		//存储数据
		request.setAttribute("zhongList", zhongList);
		request.getRequestDispatcher("/visitorList_Sate.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
