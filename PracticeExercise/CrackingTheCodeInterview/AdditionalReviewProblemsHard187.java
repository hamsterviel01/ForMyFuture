/**
Solution from text book:
- First, simplifiy: what if we only need to search for words with component of 2 words
	+ divide that word into all possible pair --> check for each pair if the left can be found and the right can be found.
- Upgrade it to words with unknown number of components
	+ Find all possible left part, once found --> continue to search for left of right part.
*/

import java.util.*;

public class AdditionalReviewProblemsHard187 {
	public static String getLongestString(String[] input){
		Hashtable<String, String> map = new Hashtable<String, String>();
		for (int i=0; i<input.length; i++){
			map.put(input[i], "unvisited");
		}

		int maxLength = 0;
		Stack<String> maxString = new Stack<String>();
		for (int i=0; i<input.length; i++){
			boolean composeOfStrings = containComponentAsString(input[i], map);
			System.out.println(input[i] + ": " + composeOfStrings);
			if (composeOfStrings){
				if (maxLength < input[i].length()){
					maxLength = input[i].length();
					maxString.push(input[i]);
				}
			}
		}

		if (maxLength == 0){
			return null;
		} else {
			return maxString.pop();
		}
	}

	public static boolean containComponentAsString(String str, Hashtable<String, String> map){
		System.out.println("String: " + str);
		if (str == null) return true;
		if (map.containsKey(str)){
			if (map.get(str) == "visistedAndFalse"){
				return false;
			} else if (map.get(str) == "visistedAndTrue") {
				return true;
			} else {

			}
		}

		ArrayList<Integer> optionsForRightPart = new ArrayList<Integer>();
		for (int i=1; i<str.length(); i++){
			String substr = str.substring(0, i);
			//need to eliminate situation where substr == str
			System.out.println(substr);
			if (map.containsKey(substr)){
				optionsForRightPart.add(i);
			}
		}

		if (optionsForRightPart.isEmpty()){
			return false;
		} else {
			boolean containComponent = false;
			for (int i=0; i<optionsForRightPart.size(); i++) {
				containComponent = containComponent || containComponentAsString(str.substring(optionsForRightPart.get(i)), map);
			}
			return containComponent;
		}
	}

	public static void main(String[] args){
		String[] input = new String[]{"defgh", "de", "def", "dedefgh", "abc"};
		System.out.println(getLongestString(input));
	}
}