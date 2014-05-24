package com.wade.framework.base.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateStringConverter extends DateConverterBase implements Converter<Date, String> {

	@Override
	public String convert(Date date) {
		if (null == date) {
			return null;
		}
		return getDateFormat().format(date);
	}
	
}
