import java.util.*;

public class AdditionalReviewProblemsHard187 {
	public static String getLongestString(String[] input){
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		for (int i=0; i<input.length; i++){
			table.put(input[i], 0);
		}

		int indexOfLongestString = -1;
		int maxLength = 0;
		for (int i=0; i<input.length; i++){
			String str = input[i];
			int length = 0;
			StringBuilder strBuilder = new StringBuilder();
			for (int j=0; j<str.length(); j++){
				strBuilder.append(str.charAt(j));

				//What if hashtable contains "de" and "def" and str = "dedef" or "defde"
				if (table.containsKey(strBuilder.toString())){
					length = length + strBuilder.length();
					//Empty strBuilder
					strBuilder.setLength(0);
				}
			}
			if (length == str.length() && length > maxLength){
				maxLength = length;
				indexOfLongestString = i;
			}
		}

		if (indexOfLongestString == -1) return null;

		return input[indexOfLongestString];
	}

	public static void main(String[] args){
		System.out.println(getLongestString(new String[]{"ab", "cd", "cde", "def", "cddefk", "cddef", "cdef", "abcdedef", "ablhg", "de", "abc"}));
		System.out.println(getLongestString(new String[]{"ab", "cd", "cde", "def", "cddefk", "cddef", "cdef", "abcdedef", "ablhg"}));
	}
}