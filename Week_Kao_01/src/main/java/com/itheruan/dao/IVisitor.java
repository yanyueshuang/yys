package com.itheruan.dao;

import java.util.List;
import java.util.Map;

/**
 * 访客dao接口
 * @author 11137
 *
 */
public interface IVisitor {
	
	/**
	 * 保存访问者
	 * @param id
	 * @param name
	 * @param company
	 * @param phone
	 */
	void saveVisitor(String id, String name, String company, String phone);
	
	/**
	 * 根据id查询访问者
	 * @param id
	 * @return
	 */
	Map<String, Object> findByIdVisitor(String id);
	
	
	/**
	 * 根据名字和手机号查询访问者
	 * @param string
	 * @param className
	 * @param classTime
	 */
	Map<String, Object> findByIdPasswordVisitor(String name,String phone);
	
	
	/**
	 * 根据名字模糊搜索访问者
	 * @param name
	 * @return
	 */
	List<Map<String, Object>> findByLikeVisitor(String name);
	
	
	
}
