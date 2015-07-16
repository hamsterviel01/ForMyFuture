public class WorksApplication20150716-1 {
	public static String longestSubString(String str1, String str2){
		Hashtable<Character, Character> str1Table = Hashtable<Character, Character>();

		for (int i=0; i<str1.length()-1; i++){
			str1Table.add(str1.charAt[i], str1.charAt[i+1]);
		}
		str1Table.add(str1.charAt[str1.length()-1], "");

		int maxCount = 0;
		int pointer=0;
		Stack<String> maxStack = new Stack<String>();
		while (pointer<str2.length()){
			char temp = str2.charAt(pointer);
			if (str1Table.containsKey(temp)){
				String subString = getSubstring(str1Table, str2, pointer);
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
			}
		}
		if (maxStack.isEmpty()){
			return null;
		}
		return maxStack.pop();
	}

	public static String getSubstring(Hashtable<Character, Character> str1Table, String str2, int pointer){
		char c = str2.charAt(pointer);
		ArrayList<Character> charArray = new ArrayList<Character>();
		while(str1Table.containsKey(c)){
			charArray.add(c);
			char next = str1Table.getValue(c);
			if (next != str2.charAt(pointer+1)){
				break;
			} else {
				c = next;
			}
		}
		
	}
}