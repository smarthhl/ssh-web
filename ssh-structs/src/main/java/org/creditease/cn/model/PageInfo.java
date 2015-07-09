package org.creditease.cn.model;

import java.util.List;

public class PageInfo<T> {
	/**
	 * 页码,默认为1
	 */
	private int pageNo=1;
	/**
	 * 每页展示数量，默认为20
	 */
	private int pageSize=10;
	private int totalPage;
	private int totalCount;
	private List<T> result;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
