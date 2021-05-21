package nasa.exoplanets.helpers;

public class StringManipulator {

	public static String firstUpperRestLowercase(String s) {

		if(s.isEmpty())
			return s;
		
		StringBuilder sb = new StringBuilder();
		
		char firstChar = s.charAt(0);
		firstChar = Character.toUpperCase(firstChar);
		sb.append(firstChar);
		
		for(int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			c = Character.toLowerCase(c);
			sb.append(c);
		}
		
		return sb.toString();
	}
	
}
