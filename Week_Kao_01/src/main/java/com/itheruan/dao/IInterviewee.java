package com.itheruan.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 被访问者dao接口
 * @author 11137
 *
 */
public interface IInterviewee {
		
	/**
	 * 查询受访者
	 * @return
	 */
	List<Map<String, Object>> findAllInterviewee();
	
	
	/**
	 * 根据id和密码查询受访者
	 * @param string
	 * @param className
	 * @param classTime
	 */
	Map<String, Object> findByIdPasswordInterviewee(String id,String password);
	
	
	/**
	 * 根据名字模糊搜索受访者
	 * @param name
	 * @return
	 */
	List<Map<String, Object>> findByLikeInterviewee(String name);
	
	
	/**
	 * 根据名字查询受访者
	 */
	Map<String, Object> findByNameInterviewee(String name);
	
}
