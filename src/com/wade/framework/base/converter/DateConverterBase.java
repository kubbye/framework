package com.wade.framework.base.converter;

import java.text.SimpleDateFormat;

/**
 * @author weih
 *
 */
public class DateConverterBase {
	private String datePattern = "yyyy-MM-dd";
	private String timePattern = "HH:mm:ss";
	private SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
	private SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datePattern
			+ " " + timePattern);

	public SimpleDateFormat getDateFormat() {
		return this.dateFormat;
	}
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}
	public SimpleDateFormat getDateTimeFormat() {
		return dateTimeFormat;
	}
	public void setDateTimeFormat(SimpleDateFormat dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}
	
	
}
