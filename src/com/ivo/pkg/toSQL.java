package com.ivo.pkg;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class toSQL {
	public static java.sql.Date convert(String birthDate) {
		String newDate = birthDate.replace("/", "-");
		
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			//surround below line with try catch block as below code throws checked exception
			java.util.Date sDate = null;
			try {
				sDate = sdf.parse(newDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date sqlDate = new java.sql.Date(sDate.getTime());
		
		return sqlDate;
		
	}
}
