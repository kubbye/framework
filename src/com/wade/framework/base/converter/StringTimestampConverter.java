package com.wade.framework.base.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringTimestampConverter  extends DateConverterBase implements Converter<String, Timestamp> {
	@Override
	public Timestamp convert(String source) {
		if (null == source) {
			return null;
		}
		String trim = source.trim();
		if (trim.length() == 0) {
			return null;
		}
		try {
			Date date = (trim.contains(":")) ? getDateTimeFormat().parse(trim) : getDateFormat().parse(trim);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			throw new RuntimeException("无效的日期格式:" + trim);
		}
	}
}
