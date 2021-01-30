package com.scorewell.job;

import com.scorewell.utils.StringUtils;

public class TestFeature {

	public static void main(String[] args) {

		long nineamTime = StringUtils.strToDate("30-01-2021", "dd-MM-yyyy").getTime()+(0 * 60 * 60 * 1000);
		System.out.println(nineamTime);
		System.out.println(StringUtils.formatDate(nineamTime, "dd-MM-yyyy HH:MM:SS"));
		
		
		
		long today = StringUtils
				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy HH:MM:SS"), "dd-MM-yyyy HH:MM:SS").getTime();
		System.out.println(today);
		System.out.println(StringUtils.formatDate(today, "dd-MM-yyyy HH:MM:SS"));
	}

}
