package org.creditease.cn.utils;

import java.text.DecimalFormat;

public class NumberUtils {
	/**
	 * 根据给定的格式格式化数字
	  * @Title: formatNumber
	  * @Description: TODO
	  * @param @param number
	  * @param @param format
	  * @param @return
	  * @return String
	  * @throws
	 */
	public static String formatNumber(Number number,String format){
		DecimalFormat decimalFormat=new DecimalFormat(format);
		return decimalFormat.format(number);
	}
	
	public static void main(String[] args) {
		System.out.println(NumberUtils.formatNumber(1890.90999, "#,###.##"));
	}
}
