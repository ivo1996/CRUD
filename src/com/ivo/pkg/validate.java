package com.ivo.pkg;


public class validate {


	public static boolean validateEmail(final String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	}
	
	public static boolean validateName( String firstName )
	   {
	      return firstName.matches( "[A-Z][a-zA-Z]*" );
	   }
	
	public static boolean validateNumber(String number)
	{
		return number.matches("[0-9]+");
	}
	
	public static boolean validateDate(String date)
	{
		return date.matches("\\d{4}-\\d{2}-\\d{2}");
	}
}
