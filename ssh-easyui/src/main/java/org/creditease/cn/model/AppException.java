package org.creditease.cn.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.transaction.SystemException;

import org.creditease.cn.utils.DateUitils;


public class AppException {

	public Date date_key;
	public BigDecimal radio;
	public String app_key;
	public BigInteger app_ver_key;
	public BigInteger app_chnl_key;
	public BigDecimal exception_cnt;
	
	public String getDate_key() throws SystemException {
		return DateUitils.getDate(date_key);
	}
	public void setDate_key(Date dateKey) {
		date_key = dateKey;
	}
	public double getRadio() {
		BigDecimal mu=new BigDecimal(100);
		return radio.multiply(mu).doubleValue();
	}
	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}
	public String getApp_key() {
		return app_key;
	}
	public void setApp_key(String appKey) {
		app_key = appKey;
	}
	public BigInteger getApp_ver_key() {
		return app_ver_key;
	}
	public void setApp_ver_key(BigInteger appVerKey) {
		app_ver_key = appVerKey;
	}
	public BigInteger getApp_chnl_key() {
		return app_chnl_key;
	}
	public void setApp_chnl_key(BigInteger appChnlKey) {
		app_chnl_key = appChnlKey;
	}
	public BigDecimal getException_cnt() {
		return exception_cnt;
	}
	public void setException_cnt(BigDecimal exceptionCnt) {
		exception_cnt = exceptionCnt;
	}
	
}
