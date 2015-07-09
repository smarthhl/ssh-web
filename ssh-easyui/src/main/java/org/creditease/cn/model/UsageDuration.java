package org.creditease.cn.model;

import java.math.BigDecimal;

public class UsageDuration {

	public String duration_type;
	public Integer xhour;
	public BigDecimal usage_count;
	public BigDecimal rate;

	public String getDuration_type() {
		return duration_type;
	}

	public void setDuration_type(String durationType) {
		duration_type = durationType;
	}

	public BigDecimal getUsage_count() {
		return usage_count;
	}

	public void setUsage_count(BigDecimal usageCount) {
		usage_count = usageCount;
	}

	public Integer getXhour() {
		return xhour;
	}

	public void setXhour(Integer xhour) {
		this.xhour = xhour;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
