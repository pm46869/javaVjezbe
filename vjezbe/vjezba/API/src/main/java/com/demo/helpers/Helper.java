package com.demo.helpers;

public class Helper {
	public static boolean isNumeric(String s) {
		try {  
		    Integer.parseInt(s);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }
	}
}
