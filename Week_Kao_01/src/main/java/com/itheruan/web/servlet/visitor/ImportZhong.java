package com.itheruan.web.servlet.visitor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itheruan.dao.impl.ZhongImpl;
import com.itheruan.utils.ExcelUtils;

@WebServlet("/visitor/importZhong")
public class ImportZhong extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fileName = "I:\\申请单.xls";
		//响应到页面之中
		ExcelUtils.settings(request, response, fileName);
		List<Map<String, Object>> list = new ZhongImpl().findAllZhong();
		System.out.println(list);
		//导出
		HSSFWorkbook workbook = new ZhongImpl().importZhong(fileName, list);
		
		System.out.println(workbook);
		 //通过流写入到工作簿中
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
