package org.creditease.cn.common;

import org.creditease.cn.model.PageInfo;
import org.json.JSONObject;

public class PageToJson {
	/**
	 * 转换前台分页
	 * @param pageInfo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static JSONObject page2Json(PageInfo pageInfo){
		JSONObject array = new JSONObject();
		array.put("rows",pageInfo.getResult());
		array.put("total", pageInfo.getTotalCount());
		return array;
	}
	/**
	 * 分页
	 * @param pageInfo
	 * @param page
	 * @param rows
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static PageInfo pageGo(PageInfo pageInfo,String page,String rows){
		int intPage = Integer.parseInt((page == null || page == "0") ? "1": page);// 当前页
		int number = Integer.parseInt((rows == null || rows == "0") ? "10": rows);// 每页显示条数
		pageInfo.setPageSize(number);
		pageInfo.setPageNo(intPage);
		return pageInfo;
	}
}
