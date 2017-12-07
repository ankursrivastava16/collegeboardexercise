package com.collegeboard.codeassignment.test;

import org.junit.Test;
import org.junit.Assert;

import com.collegeboard.codeassignment.StudentUtil;

public class StudentUtilTest {

	@Test
	public void findgradeTest() {
		// TODO Auto-generated method stub
		int value = StudentUtil.getGradeOnGivenDate1("2016-06-30", "2002-06-20");
		System.out.println(value);
		Assert.assertEquals(value, -1);

	}
}
