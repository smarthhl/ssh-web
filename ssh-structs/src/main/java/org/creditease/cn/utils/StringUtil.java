package org.creditease.cn.utils;

/**
 * 
 * @ClassName: StringUtils
 * @Description: TODO
 * @author caliph
 * @date Apr 21, 2015 2:23:01 PM
 */
public class StringUtil {
	public static String encodePassword(String pro, String password)
			throws Exception {
		return MD5Util.md5Encode(pro + password);
	}

	/**
	 * 
	* @Title: isDemoUser
	* @Description: TODO(用户过滤)
	* @param @param username
	* @param @return    设定文件
	* @return boolean    返回类型
	* @throws
	 */
	public static boolean isDemoUser(String username) {
		if ("admin@creditease.cn".equalsIgnoreCase(username)) {
			return true;
		}
		return false;
	}
}
