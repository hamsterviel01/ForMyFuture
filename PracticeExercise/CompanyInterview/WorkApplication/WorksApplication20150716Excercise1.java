import java.util.*;

//This algo only work if str1's characters are unique.

public class WorksApplication20150716Excercise1 {
	public static String longestSubString(String str1, String str2){
		Hashtable<Character, Character> str1Table = new Hashtable<Character, Character>();

		//Set hastable of value = char and key = next char for str1;
		for (int i=0; i<str1.length()-1; i++){
			str1Table.put(str1.charAt(i), str1.charAt(i+1));
		}
		str1Table.put(str1.charAt(str1.length()-1), '\u0000');

		int maxCount = 0;
		int pointer=0;
		Stack<String> maxStack = new Stack<String>();
		while (pointer<str2.length()){
			char temp = str2.charAt(pointer);
			//if char of str2 is contained inside str1 --> check if longer substring is found
			if (str1Table.containsKey(temp)){
				String subString = getSubstring(str1Table, str2, pointer);
				System.out.println("Component substring: " + subString + " pointer: " + pointer + " length: " + subString.length());
				if (subString.length() > maxCount){
					maxCount = subString.length();
					maxStack.push(subString);
				}
				//subString.length() or subString.length() -1 ???
				if (subString != null){
					pointer = pointer + subString.length();
				} else {
					pointer++;
				}	
			} else {
				pointer++;
			}
		}
		if (maxStack.isEmpty()){
			return null;
		}
		return maxStack.pop();
	}

	public static String getSubstring(Hashtable<Character, Character> str1Table, String str2, int pointer){
		char c = str2.charAt(pointer);
		char[] charArray = new char[str2.length()];
		int index = 0;
		while(str1Table.containsKey(c) && pointer < str2.length()){
			System.out.println("char: " + c);
			charArray[index] = c;
			index++;
			char next = str1Table.get(c);
			if (pointer < str2.length() - 1){
				if (next != str2.charAt(pointer+1)){
					System.out.println(str1Table);
					break;
				} else {
					System.out.println(str1Table);
					c = next;
					pointer++;
				}
			} else { //This is to cater the case when last string at str2 was contained inside str1 --> pointer need to jump 2 steps instead of 1;
				pointer = pointer + 2;
			}
		}
		int i = 0;
		StringBuilder str = new StringBuilder();
		while (charArray[i] != '\u0000'){
			str.append(charArray[i]);
			i++;
		}

		return new String(str);
	}

	public static void main(String[] args){
		//Testing fail at ee
		System.out.println(longestSubString("GeeksforGeeks", "GeeksQuiz"));
	}
}