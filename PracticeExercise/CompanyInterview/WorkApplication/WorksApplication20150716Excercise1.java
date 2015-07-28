import java.util.*;

public class WorksApplication20150716Excercise1 {
	public static String longestSubstring(String shortStr, String longStr){
		Hashtable<Character, ArrayList<Integer>> charMap = new Hashtable<Character, ArrayList<Integer>>();

		//Store max substring
		int maxLength = 0;
		Stack<String> maxStack = new Stack<String>();

		//Put all char into a hashtable for fast look up of its positions.
		for (int i=0; i<longStr.length(); i++){
			if (charMap.containsKey(longStr.charAt(i))){
				charMap.get(longStr.charAt(i)).add(i);
			} else {
				charMap.put(longStr.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
			}
		}

		for (int i=0; i<shortStr.length(); i++){
			if (charMap.containsKey(shortStr.charAt(i))){
				ArrayList<Integer> positions = charMap.get(shortStr.charAt(i));
				for (int j=0; j<positions.size(); j++){
					int k = positions.get(j);
					int tempPointer = i;
					StringBuilder strBuilder = new StringBuilder();
					while (tempPointer < shortStr.length() && k < longStr.length() && shortStr.charAt(tempPointer) == longStr.charAt(k)){
						strBuilder.append(String.valueOf(shortStr.charAt(tempPointer)));
						tempPointer++;
						k++;
					}
					//Check if new substring is max and push it to stack.
					if (strBuilder.length() > maxLength){
						maxLength = strBuilder.length();
						maxStack.push(strBuilder.toString());
					}
				}
			}
		}

		if (maxStack.isEmpty()){
			return "";
		} else {
			return maxStack.peek();
		}
	}

	public static void main(String[] args){
		System.out.println(longestSubstring("abcdeefghaikl", "deefgabcikltegeefghaik"));
	}
}