package com.scorewell.job;

import com.scorewell.utils.StringUtils;

public class TestFeature {

	public static void main(String[] args) {

		System.out.println("HI");
		
//		long nineamTime = StringUtils.strToDate("30-01-2021", "dd-MM-yyyy").getTime()+(2 * 70 * 60 * 1000);
//		System.out.println(nineamTime);
//		System.out.println(StringUtils.strToDate("30-01-2021", "dd-MM-yyyy").getTime()+(2 * 80 * 60 * 1000));
//		System.out.println(StringUtils.formatDate(1612200600000L, "dd-MM-yyyy HH:mm:ss"));
//		
		long today = StringUtils
				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy HH:mm:ss"), "dd-MM-yyyy HH:mm:ss").getTime();
		System.out.println(today);
		System.out.println(StringUtils.formatDate(today, "dd-MM-yyyy HH:mm:ss"));
		
		System.out.println("Yoo : "+StringUtils.strToDate("03-02-2021", "dd-MM-yyyy").getTime()+(3 * 90 * 60 * 1000));
		System.out.println(StringUtils.formatDate(StringUtils.strToDate("03-02-2021", "dd-MM-yyyy").getTime()+(3 * 70 * 60 * 1000), "dd-MM-yyyy HH:mm:ss"));
		
		
		today = StringUtils
				.strToDate(StringUtils.formatDate(System.currentTimeMillis(), "dd-MM-yyyy"), "dd-MM-yyyy").getTime()+(1 * 70 * 60 * 1000);
		System.out.println(StringUtils.formatDate(today, "dd-MM-yyyy HH:mm:ss"));
	}

}
