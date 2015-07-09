package org.creditease.cn.common;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.mapping.Column;

import com.google.common.collect.Lists;

public class Datagrid<T> {

	private long total;

	private List<Column> columns = Lists.newArrayList();

	private List<T> rows;

	private List<Map<String, Object>> footer;

	public Datagrid() {
	}

	public Datagrid(long total, List<T> rows) {
		this(total, null, rows, null);
	}

	public Datagrid(long total, List<Column> columns, List<T> rows, List<Map<String, Object>> footer) {
		this.total = total;
		this.columns = columns;
		this.rows = rows;
		this.footer = footer;
	}
	public long getTotal() {
		return this.total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return this.rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public List<Map<String, Object>> getFooter() {
		return this.footer;
	}

	public void setFooter(List<Map<String, Object>> footer) {
		this.footer = footer;
	}

	public List<Column> getColumns() {
		return this.columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}