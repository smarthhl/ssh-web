package org.creditease.cn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.creditease.cn.utils.DateUitils;


@Entity
@Table(name = "app_evt_effect")
public class BIEvnEffect  implements Serializable, IBaseModel  {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "date_key")
	public Date date_key;
	@Column(name = "app_key")
	public String app_key;
	@Column(name = "app_ver_key")
	public BigInteger app_ver_key;
	@Column(name = "app_chnl_key")
	public BigInteger app_chnl_key;
	@Column(name = "os")
	public String os;
	@Column(name = "goods")
	public String goods; // varchar(200) DEFAULT NULL COMMENT '产品名称',
	@Column(name = "curr_act_cnt")
	public BigInteger curr_act_cnt;// int(11) DEFAULT NULL COMMENT '当天激活用户数',
	@Column(name = "curr_reg_cnt")
	public BigInteger curr_reg_cnt;// int(11) DEFAULT NULL COMMENT '当天注册用户数',
	@Column(name = "curr_auth_cnt")
	public BigInteger curr_auth_cnt;// int(11) DEFAULT NULL COMMENT '当天认证用户数',
	@Column(name = "curr_bind_cnt")
	public BigInteger curr_bind_cnt;// int(11) DEFAULT NULL COMMENT '当天绑卡用户数',
	@Column(name = "curr_po_cnt")
	public BigInteger curr_po_cnt;// int(11) DEFAULT NULL COMMENT '当天下单用户数',
	@Column(name = "curr_trad_cnt")
	public BigInteger curr_trad_cnt;// int(11) DEFAULT NULL COMMENT '当天交易用户数',
	@Column(name = "curr_trad_amt")
	public BigInteger curr_trad_amt;// decimal(16,4) DEFAULT NULL COMMENT
									// '当天交易总金额',
	@Column(name = "accu_act_cnt")
	public BigInteger accu_act_cnt;// int(11) DEFAULT NULL COMMENT '累计激活用户数',
	@Column(name = "accu_reg_cnt")
	public BigInteger accu_reg_cnt;// int(11) DEFAULT NULL COMMENT '累计注册用户数',
	@Column(name = "accu_auth_cnt")
	public BigInteger accu_auth_cnt;// int(11) DEFAULT NULL COMMENT '累计认证用户数',
	@Column(name = "accu_bind_cnt")
	public BigInteger accu_bind_cnt;// int(11) DEFAULT NULL COMMENT '累计绑卡用户数',
	@Column(name = "accu_po_cnt")
	public BigInteger accu_po_cnt;// int(11) DEFAULT NULL COMMENT '累计下单用户数',
	@Column(name = "accu_trad_cnt")
	public BigInteger accu_trad_cnt;// int(11) DEFAULT NULL COMMENT '累计交易用户数',
	@Column(name = "app_name")
	public BigDecimal accu_trad_amt;// decimal(16,4) DEFAULT NULL COMMENT
									// '累计交易总金额',
	@Column(name = "create_time")
	public Date create_time;// NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT
							// '记录创建时间',
	@Column(name = "update_time")
	public Date update_time;

	@Override
	public Serializable getId() {
		return id;
	}

	@Override
	public void setId(Serializable value) {
		// TODO Auto-generated method stub
		this.id=(Long)value;
	}
	public String getDate_key() {
		return DateUitils.getDatetime(date_key);
	}

	public void setDate_key(Date date_key) {
		this.date_key = date_key;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public BigInteger getApp_ver_key() {
		return app_ver_key;
	}

	public void setApp_ver_key(BigInteger app_ver_key) {
		this.app_ver_key = app_ver_key;
	}

	public BigInteger getApp_chnl_key() {
		return app_chnl_key;
	}

	public void setApp_chnl_key(BigInteger app_chnl_key) {
		this.app_chnl_key = app_chnl_key;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public BigInteger getCurr_act_cnt() {
		return curr_act_cnt;
	}

	public void setCurr_act_cnt(BigInteger curr_act_cnt) {
		this.curr_act_cnt = curr_act_cnt;
	}

	public BigInteger getCurr_reg_cnt() {
		return curr_reg_cnt;
	}

	public void setCurr_reg_cnt(BigInteger curr_reg_cnt) {
		this.curr_reg_cnt = curr_reg_cnt;
	}

	public BigInteger getCurr_auth_cnt() {
		return curr_auth_cnt;
	}

	public void setCurr_auth_cnt(BigInteger curr_auth_cnt) {
		this.curr_auth_cnt = curr_auth_cnt;
	}

	public BigInteger getCurr_bind_cnt() {
		return curr_bind_cnt;
	}

	public void setCurr_bind_cnt(BigInteger curr_bind_cnt) {
		this.curr_bind_cnt = curr_bind_cnt;
	}

	public BigInteger getCurr_po_cnt() {
		return curr_po_cnt;
	}

	public void setCurr_po_cnt(BigInteger curr_po_cnt) {
		this.curr_po_cnt = curr_po_cnt;
	}

	public BigInteger getCurr_trad_cnt() {
		return curr_trad_cnt;
	}

	public void setCurr_trad_cnt(BigInteger curr_trad_cnt) {
		this.curr_trad_cnt = curr_trad_cnt;
	}

	public BigInteger getCurr_trad_amt() {
		return curr_trad_amt;
	}

	public void setCurr_trad_amt(BigInteger curr_trad_amt) {
		this.curr_trad_amt = curr_trad_amt;
	}

	public BigInteger getAccu_act_cnt() {
		return accu_act_cnt;
	}

	public void setAccu_act_cnt(BigInteger accu_act_cnt) {
		this.accu_act_cnt = accu_act_cnt;
	}

	public BigInteger getAccu_reg_cnt() {
		return accu_reg_cnt;
	}

	public void setAccu_reg_cnt(BigInteger accu_reg_cnt) {
		this.accu_reg_cnt = accu_reg_cnt;
	}

	public BigInteger getAccu_auth_cnt() {
		return accu_auth_cnt;
	}

	public void setAccu_auth_cnt(BigInteger accu_auth_cnt) {
		this.accu_auth_cnt = accu_auth_cnt;
	}

	public BigInteger getAccu_bind_cnt() {
		return accu_bind_cnt;
	}

	public void setAccu_bind_cnt(BigInteger accu_bind_cnt) {
		this.accu_bind_cnt = accu_bind_cnt;
	}

	public BigInteger getAccu_po_cnt() {
		return accu_po_cnt;
	}

	public void setAccu_po_cnt(BigInteger accu_po_cnt) {
		this.accu_po_cnt = accu_po_cnt;
	}

	public BigInteger getAccu_trad_cnt() {
		return accu_trad_cnt;
	}

	public void setAccu_trad_cnt(BigInteger accu_trad_cnt) {
		this.accu_trad_cnt = accu_trad_cnt;
	}

	public BigDecimal getAccu_trad_amt() {
		return accu_trad_amt;
	}

	public void setAccu_trad_amt(BigDecimal accu_trad_amt) {
		this.accu_trad_amt = accu_trad_amt;
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

}
