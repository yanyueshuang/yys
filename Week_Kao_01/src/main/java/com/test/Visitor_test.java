package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itheruan.dao.impl.IntervieweeImpl;
import com.itheruan.dao.impl.VisitorImpl;

public class Visitor_test {
	/**
	 * 模糊查询访问者
	 */
	@Test
	public void test_03() {
		List<Map<String, Object>> list = new VisitorImpl().findByLikeVisitor("z");
		System.out.println(list);
		
	}
}
