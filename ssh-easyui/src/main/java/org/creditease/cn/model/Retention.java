package org.creditease.cn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.SystemException;

import org.creditease.cn.utils.DateUitils;


public class Retention {
	public Date date_key;
	public BigDecimal radio;
	public String period_type;
	
	public String getDate_key() throws SystemException {
		return DateUitils.getDate(date_key);
	}
	public void setDate_key(Date dateKey) {
		date_key = dateKey;
	}
	public double  getRadio() {
		BigDecimal mu=new BigDecimal(100);
		return radio.multiply(mu).doubleValue();
	}
	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}
	public String getPeriod_type() {
		return period_type;
	}
	public void setPeriod_type(String periodType) {
		period_type = periodType;
	}
	
	
}
