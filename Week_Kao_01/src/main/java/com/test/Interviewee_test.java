package com.test;

import java.util.List;
import java.util.Map;

import javax.sound.midi.Soundbank;

import org.junit.Test;

import com.itheruan.dao.impl.IntervieweeImpl;

public class Interviewee_test {

	/**
	 * 受访者登录
	 */
	@Test
	public void test_01() {
		Map<String, Object> map = new IntervieweeImpl().findByIdPasswordInterviewee("1001", "111");
		System.out.println(map==null);
		System.out.println(map);
		System.out.println(map.size());
		//findAllInterviewee
	}
	
	/**
	 * 查询所有受访者
	 */
	@Test
	public void test_02() {
		List<Map<String, Object>> list = new IntervieweeImpl().findAllInterviewee();
		System.out.println(list);
		
	}
	
	/**
	 * 模糊查询受访者
	 */
	@Test
	public void test_03() {
		List<Map<String, Object>> list = new IntervieweeImpl().findByLikeInterviewee("11111");
		System.out.println(list);
		
	}
	
	
	/**
	 * 精确查询受访者
	 */
	@Test
	public void test_04() {
	
		Map<String, Object> map = new IntervieweeImpl().findByNameInterviewee("1111");
		System.out.println(map);
		
	}
}
