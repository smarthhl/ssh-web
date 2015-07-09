package org.creditease.cn.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.transaction.SystemException;

import org.creditease.cn.utils.DateUitils;


public class AppStatistic {

	public Date date_key;
	public BigDecimal act_user_cnt;
	public BigDecimal new_user_cnt;
	public BigDecimal new_user_active_cnt;
	public BigDecimal rate;
	public String app_key;
	public BigInteger app_ver_key;
	public String app_chnl_key;
	public String   period_type;
	
	public String getDate_key() throws SystemException {
		return DateUitils.getDate(date_key);
	}
	public void setDate_key(Date dateKey) {
		date_key = dateKey;
	}
	public String getApp_key() {
		return app_key;
	}
	public void setApp_key(String appKey) {
		app_key = appKey;
	}
	public BigDecimal getNew_user_cnt() {
		return new_user_cnt;
	}
	public void setNew_user_cnt(BigDecimal newUserCnt) {
		new_user_cnt = newUserCnt;
	}
	public BigDecimal getAct_user_cnt() {
		return act_user_cnt;
	}
	public void setAct_user_cnt(BigDecimal actUserCnt) {
		act_user_cnt = actUserCnt;
	}
	public BigInteger getApp_ver_key() {
		return app_ver_key;
	}
	public void setApp_ver_key(BigInteger appVerKey) {
		app_ver_key = appVerKey;
	}
	public String getApp_chnl_key() {
		return app_chnl_key;
	}
	public void setApp_chnl_key(String appChnlKey) {
		app_chnl_key = appChnlKey;
	}
	public BigDecimal getNew_user_active_cnt() {
		return new_user_active_cnt;
	}
	public void setNew_user_active_cnt(BigDecimal newUserActiveCnt) {
		new_user_active_cnt = newUserActiveCnt;
	}
	public double getRate() {
		BigDecimal mu=new BigDecimal(100);
		return rate.multiply(mu).doubleValue();
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getPeriod_type() {
		return period_type;
	}
	public void setPeriod_type(String periodType) {
		period_type = periodType;
	}
	
}
