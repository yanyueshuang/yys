package com.itheruan.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.IInterviewee;
import com.itheruan.utils.JDBCUtils;

/**
 * 被访问者dao实现类
 * 
 * @author 11137
 *
 */
public class IntervieweeImpl implements IInterviewee {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

	/**
	 * 查询受访者
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findAllInterviewee() {
		try {
			// TODO Auto-generated method stub
			String sql = "select * from interviewee";
			return jdbcTemplate.queryForList(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * 根据id和密码查询受访者
	 * 
	 * @param string
	 * @param className
	 * @param classTime
	 */
	@Override
	public Map<String, Object> findByIdPasswordInterviewee(String id, String password) {
		try {
			// TODO Auto-generated method stub
			String sql = "select * from Interviewee where interviewee_id = ? and interviewee_password = ?";
			int interviewee_id = Integer.parseInt(id);
			return jdbcTemplate.queryForMap(sql, interviewee_id, password);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/**
	 * 根据名字模糊搜索受访者
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findByLikeInterviewee(String name) {
		try {
			// TODO Auto-generated method stub
			String sql = "select * from Interviewee where interviewee_name like ?";
			name = "%" + name + "%";
			return jdbcTemplate.queryForList(sql, name);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	/**
	 * 根据名字查询受访者
	 */
	@Override
	public Map<String, Object> findByNameInterviewee(String name) {
		try {
			// TODO Auto-generated method stub
			String sql = "select * from Interviewee where Interviewee_name = ?";
			return jdbcTemplate.queryForMap(sql,name);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
