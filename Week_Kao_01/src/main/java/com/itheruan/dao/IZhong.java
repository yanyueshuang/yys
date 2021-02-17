package com.itheruan.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface IZhong {
	
	/**
	 * 保存访问者和受访问者id和时间
	 */
	void saveZhong(String intervieweeId,String visitorId,Date time,String state);
	
	
	/**
	 * 根据访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	List<Map<String, Object>> findByVisitorIdZhong(Integer visitorId);
	
	
	/**
	 * 根据受访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	List<Map<String, Object>> findByIntervieweeIdIdZhong(Integer intervieweeId);
	
	
	/**
	 * 查询所有访问单
	 */
	List<Map<String, Object>> findAllZhong();
	
	
	/**
	 * 导入Excel表
	 */
	HSSFWorkbook importZhong(String fileName, List<Map<String, Object>> examList);

}
