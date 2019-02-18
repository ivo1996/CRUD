package com.ivo.pkg;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//Method that converts a string into a java.sql.Date object
public class toSQL {
	public static java.sql.Date convert(String birthDate) {
		//trims the string from all characters and leaves only digits and separating characters
		String newDate = birthDate.replaceAll("[^\\d-]", "");
		//initializes an object of type java.sql.Date
		java.sql.Date sqlDate = null;
		//Check if the format is the right type, done so that the parse should not go into exception
		if(newDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date sDate = null;
			try {
				sDate = sdf.parse(newDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			sqlDate = new java.sql.Date(sDate.getTime());
		}
		return sqlDate;
		
	}
}
