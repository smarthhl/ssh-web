package org.creditease.cn.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SortAndDistinctList {

	/**
	 * 去重
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList distinct(ArrayList list){
		
		return new ArrayList(new HashSet(list));
	}
	/**
	 * 排序
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList sortList(ArrayList list){
		Collections.sort(list);
		return list;
	}
	/**
	 * 去重后排序
	 * @param list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList sortAnddisList(ArrayList list){
		list=distinct(list);
		list=sortList(list);
		return list;
	}
}
