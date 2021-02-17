package com.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.itheruan.dao.impl.VisitorImpl;
import com.itheruan.dao.impl.ZhongImpl;

public class Zhong_test {
	
	/**
	 * 根据访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	@Test
	public void test_01() {
		
		List<Map<String, Object>> list = new ZhongImpl().findByVisitorIdZhong(1);
		System.out.println(list);
	}
	/**
	 * 根据访问者id查询访问单
	 * @param visitorId
	 * @return
	 */
	@Test
	public void test_02() {
		
		List<Map<String, Object>> list = new ZhongImpl().findAllZhong();
		System.out.println(list);
	}

}
