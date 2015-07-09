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
@Table(name = "bi_user")
public class BIUser implements Serializable {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -6685989542064207011L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "pswd")
	private String pswd;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "qq")
	private String qq;

	@Column(name = "company_name")
	private String company_name;

	@Column(name = "create_time")
	private Date create_time;

	@Column(name = "update_time")
	private Date update_time;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
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
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		try {
			Field[] fields=this.getClass().getDeclaredFields();
			for(Field field:fields)
			{
				if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
					field.setAccessible(true);
					sb.append(field.getName()).append("=").append(field.get(this)).append(",");
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
