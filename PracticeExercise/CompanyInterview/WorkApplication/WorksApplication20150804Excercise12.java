public class WorksApplication20150804Excercise12 {
	//Time Complexity O(n)
	public static String longestSubstring(String input){
		int maxlength = 0;
		StringBuilder sbMax = new StringBuilder();
		for (int i=0; i<input.length()-1; i++){
			StringBuilder sb = new StringBuilder();
			sb.append(input.charAt(i));
			while(i < input.length()-1 && input.charAt(i+1) > input.charAt(i)){
				sb.append(input.charAt(i+1));
				i++;
			}
			if (sb.length() > maxlength && sb.length() > 1){
				maxlength = sb.length();
				sbMax = sb;
			}
		}
		if (sbMax.length() == 0){
			return null;
		}
		return sbMax.toString();

	}

	public static void main(String[] args){
		String input = "adcdhfadeftuvxyzghikabcdefghi";
		System.out.println(longestSubstring(input));
	}
}