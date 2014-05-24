package com.wade.framework.base.converter;

import java.sql.Timestamp;

import org.springframework.core.convert.converter.Converter;

public class TimestampStringConverter  extends DateConverterBase implements Converter<Timestamp, String>  {

	@Override
	public String convert(Timestamp date) {
		if(null == date){
			return null;
		}
		return getDateTimeFormat().format(date);
	}
}
