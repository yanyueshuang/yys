package com.itheruan.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.itheruan.dao.IVisitor;
import com.itheruan.utils.JDBCUtils;

/**
 * 访客dao实现类
 * @author 11137
 *
 */
public class VisitorImpl implements IVisitor{
	 private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
	 
	 /**
	  * 保存访问者
	  */
	public void saveVisitor(String name, String sex, String company, String phone) {
		// TODO Auto-generated method stub
		String sql = "insert into visitor(visitor_name,visitor_sex,visitor_company,visitor_phone) values(?,?,?,?)";
        jdbcTemplate.update(sql, name, sex, company,phone);
	}
	
	
	/**
	 * 根据第查询访问者
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> findByIdVisitor(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from visitor where visitor_id = ?";
		return null;
	}

	/**
	 * 根据名字和手机号查询访问者
	 * @param string
	 * @param className
	 * @param classTime
	 */
	@Override
	public Map<String, Object> findByIdPasswordVisitor(String name, String phone) {
		// TODO Auto-generated method stub
		String sql = "select * from visitor where visitor_name = ? and visitor_phone = ?";
		return jdbcTemplate.queryForMap(sql, name,phone);
	}

	/**
	 * 根据名字模糊搜索访问者
	 * @param name
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findByLikeVisitor(String name) {
		try {
			// TODO Auto-generated method stub
			String sql = "select * from Visitor where visitor_name like ?";
			name = "%" + name + "%";
			return jdbcTemplate.queryForList(sql, name);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	
}
