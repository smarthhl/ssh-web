package org.creditease.cn.utils;

/**
 * 
 * @ClassName: StringUtils
 * @Description: TODO
 * @author caliph
 * @date Apr 21, 2015 2:23:01 PM
 */
public class StringUtils {
	public static String encodePassword(String pro, String password)
			throws Exception {
		return MD5Util.md5Encode(pro + password);
	}
}
