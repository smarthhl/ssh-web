package org.creditease.cn.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.creditease.cn.utils.DateUitils;

@Entity
@Table(name = "bi_app_key")
public class BIAppKey implements Serializable {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -8784203786040330306L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id")
	private BigInteger user_id;

	@Column(name = "app_name")
	private String app_name;

	@Column(name = "app_pkg_name")
	private String app_pkg_name;

	@Column(name = "app_type_id")
	private BigInteger app_type_id;

	@Column(name = "app_desc")
	private String app_desc;

	@Column(name = "app_key")
	private String app_key;

	@Column(name = "valid_from")
	private Date valid_from;

	@Column(name = "valid_to")
	private Date valid_to;

	@Column(name = "create_time")
	private Date create_time;

	@Column(name = "update_time")
	private Date update_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getUser_id() {
		return user_id;
	}

	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getApp_pkg_name() {
		return app_pkg_name;
	}

	public void setApp_pkg_name(String app_pkg_name) {
		this.app_pkg_name = app_pkg_name;
	}

	public BigInteger getApp_type_id() {
		return app_type_id;
	}

	public void setApp_type_id(BigInteger app_type_id) {
		this.app_type_id = app_type_id;
	}

	public String getApp_desc() {
		return app_desc;
	}

	public void setApp_desc(String app_desc) {
		this.app_desc = app_desc;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getValid_from() {
		return DateUitils.getDatetime(valid_from);
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public String getValid_to() {
		return DateUitils.getDatetime(valid_to);
	}

	public void setValid_to(Date valid_to) {
		this.valid_to = valid_to;
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
