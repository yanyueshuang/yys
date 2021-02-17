package com.itheruan.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跳转错误页面工具类
 * @author 11137
 *
 */
public class Error {
	public static void getError(HttpServletRequest request, HttpServletResponse response,String name) throws ServletException, IOException {
		request.setAttribute("error",name);
		request.getRequestDispatcher("/manage/error.jsp").forward(request, response);
	}
}
