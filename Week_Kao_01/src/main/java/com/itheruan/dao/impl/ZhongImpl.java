package com.itheruan.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.IZhong;
import com.itheruan.utils.ExcelUtils;
import com.itheruan.utils.JDBCUtils;

public class ZhongImpl implements IZhong{

	 private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
	/**
	 * 根据id和密码查询受访者
	 * @param string
	 * @param className
	 * @param classTime
	 */
	@Override
	public void saveZhong(String intervieweeId, String visitorId, Date time,String state) {
		// TODO Auto-generated method stub
		String sql = "insert into zhong(interviewee_id,visitor_id,time,state) values(?,?,?,?)";
        jdbcTemplate.update(sql, intervieweeId, visitorId, time,state);
	}
	
	/**
	 * 根据访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findByVisitorIdZhong(Integer visitorId) {
		// TODO Auto-generated method stub
String sql  = "SELECT \r\n" + 
		"\r\n" + 
		"	z.id,v.visitor_id,v.visitor_name,interviewee_name,z.state\r\n" + 
		"\r\n" + 
		"FROM \r\n" + 
		"	visitor v,zhong z,interviewee i \r\n" + 
		"WHERE \r\n" + 
		"	v.visitor_id  = z.visitor_id \r\n" + 
		"AND \r\n" + 
		"	i.interviewee_id = z.interviewee_id\r\n" + 
		"and v.visitor_id = ?";
		return jdbcTemplate.queryForList(sql,visitorId);
	}
	
	/**
	 * 根据受访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findByIntervieweeIdIdZhong(Integer intervieweeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	/**
	 * 导入Excel表
	 */
	@Override
	public HSSFWorkbook importZhong(String fileName, List<Map<String, Object>> examList) {
		// TODO Auto-generated method stub
		
		
		//System.out.println(examList);
		//创建工作表
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("请假申请单");
		
		//定义标题数组
		String[] biaoTi = { "申请人单号","申请人id", "申请人名字", "被申请人","当前状态" };
		//定义key值
		String[] columnName = { "id","visitor_id","visitor_name","interviewee_name","state"};
		
		//创建第一行
		HSSFRow firstRow = sheet.createRow(0);
		//存入标题
		for (int i = 0; i < biaoTi.length; i++) {
			String string = biaoTi[i];
			//创建每一列
			HSSFCell firstCell = firstRow.createCell(i);
			//存入数据
			firstCell.setCellValue(string);
		}
		
		//从第二行开始向表格中添加数据
		for(int i =0;i<examList.size();i++)
		{
	     HSSFRow row2 = sheet.createRow(i+1);
	 	 sheet.autoSizeColumn(i, true);//poi自带的解决表格中的数据自动适配宽度（对中文不太好使）
		 Map<String, Object> map = examList.get(i);//取出list_examinee中的map,其实就是数据库表中的一行数据	
		
		  for(int k=0;k<columnName.length;k++)
		  {
			  row2.createCell(k).setCellValue((map.get(columnName[k])).toString());
		  }
		}
		
		ExcelUtils.setColumnAutoAdapter(sheet, examList.size());

	    return workbook;
	}
	
	/**
	 * 查询所有访问单
	 */
	@Override
	public List<Map<String, Object>> findAllZhong() {
		// TODO Auto-generated method stub
		String sql  = "SELECT \r\n" + 
				"\r\n" + 
				"	z.id,v.visitor_id,v.visitor_name,interviewee_name,z.state\r\n" + 
				"\r\n" + 
				"FROM \r\n" + 
				"	visitor v,zhong z,interviewee i \r\n" + 
				"WHERE \r\n" + 
				"	v.visitor_id  = z.visitor_id \r\n" + 
				"AND \r\n" + 
				"	i.interviewee_id = z.interviewee_id\r\n" + 
				"";
				return jdbcTemplate.queryForList(sql);
	}

}
