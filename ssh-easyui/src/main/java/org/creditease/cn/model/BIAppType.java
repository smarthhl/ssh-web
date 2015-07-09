package org.creditease.cn.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.creditease.cn.utils.DateUitils;


@Entity
@Table(name = "bi_app_type")
public class BIAppType implements Serializable {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -8531170545001055699L;

	@Id
	@GeneratedValue
	@Column(name = "app_type_id")
	private Long app_type_id;

	@Column(name = "app_type")
	private String app_type;

	@Column(name = "create_time")
	private Date create_time;

	@Column(name = "update_time")
	private Date update_time;

	public Long getApp_type_id() {
		return app_type_id;
	}

	public void setApp_type_id(Long app_type_id) {
		this.app_type_id = app_type_id;
	}

	public String getApp_type() {
		return app_type;
	}

	public void setApp_type(String app_type) {
		this.app_type = app_type;
	}

	public String getCreate_time() {
		return DateUitils.getDatetime(create_time);
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return DateUitils.getDatetime(update_time);
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
					field.setAccessible(true);
					sb.append(field.getName()).append("=")
							.append(field.get(this)).append(",");
				}
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sb.append("]");

		return sb.toString();
	}

}
