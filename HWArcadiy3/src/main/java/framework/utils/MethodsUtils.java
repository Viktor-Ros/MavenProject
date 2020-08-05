package framework.utils;

public class MethodsUtils {
	
	public static String returnNumber(String value) {
		
		String numValue = value.replaceAll("[^\\d,]", "");
		
		return numValue;
	}
	
	public static String returnLetters(String value) {
		
		String clean = value.replaceAll("[^\\а-яёА-ЯЁ\\d %]", "").replaceAll("  ", " ").replaceAll("месяцев", " месяцев");

		return clean;
	}
}
