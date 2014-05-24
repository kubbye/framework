package com.wade.framework.base.converter;

import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDateConverter extends DateConverterBase implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if(null == source) {
			return null;
		}
		String trim = source.trim();
		if(trim.length() == 0) {
			return null;
		}
		try {
			return (trim.contains(":")) ? getDateTimeFormat().parse(trim) : getDateFormat().parse(trim);
		} catch (ParseException e) {
			throw new RuntimeException("无效的日期格式:" + trim);
		}
	}
	
}
