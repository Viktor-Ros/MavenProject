package framework.utils;


public class MethodsUtils {
	
	public static String returnNumber(String value) {
		
		String numValue = "";
		for(int i = 0; i < value.length();i++) {
			
			char ch = value.charAt(i);
			
			if(ch == ',' || Character.isDigit(ch) == true) {
				numValue +=ch;
			}	
		}		
		return numValue;
	}
}