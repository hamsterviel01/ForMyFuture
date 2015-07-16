import java.util.*;

public class SortingAndSearching12 {
	//Solution in Textbook
	public static String[] sortArrayString(String[] stringArray){
		Hashtable<String, LinkedList<String>> table = new Hashtable<String, LinkedList<String>>();
		String[] results = new String[stringArray.length];

		for (String str: stringArray){
			String sortedStr = sortString(str);
			if (table.contains(sortedStr)){
				table.getValue(sortedStr).add(str);
			} else {
				table.add(sortedStr, new LinkedList<String>());
				table.getValue(sortedStr).add(str);
			}
		}

		int i = 0;
		for (String key: table.keySet()){
			LinkedList<String> list = table.getKey(key);
			for (String str: list){
				results[i] = str;
				i++;
			}
		}
	}

	public static String sortString(String str){
		return null;
	}

	public static void main(String[] args){
		String[] stringArray = new String[]{"asdccab", "adfd", "dffs", "sdddss", "sdacbac", "sdsdsd", "cabdsac", "assdf"};
		String[] newStringArray = sortArrayString(stringArray);
		for (int i=0; i<newStringArray.length; i++){
			System.out.print(newStringArray[i] + "; ");
		}
		System.out.println();
	}
}

/**
//My stupid solution
	//Use LinkedHashMap to check if current string was already contained inside sorted list 
	public static String[] sortArrayString(String[] stringArray){
		String[] newStringArray = new String[stringArray.length];
		int newIndex = 0;
		int endIndex = stringArray.length -1;
		for(int i=0; i<stringArray.length; i++){
			if (stringArray[i] != null){
				String temp = stringArray[i];
				stringArray[i] = null;
				newStringArray[newIndex] = temp;
				newIndex++;
				for (int j=0; j<stringArray.length; j++){
					if (stringArray[j] != null && j != i){
						if (isAnagram(temp, stringArray[j])){
							newStringArray[newIndex] = stringArray[j];
							newIndex++;
							stringArray[j] = null;
						}
					}
				}
			}
		}
		return newStringArray;
	}

	//Runtime - 2n, space - 1, efficient if the strings are long (>= 16 chars)
	public static boolean isAnagram(String str1, String str2){
		if (str1.length() != str2.length()){
			return false;
		}
		int[] allChar = new int[256];
		for (int i=0; i<str1.length(); i++){
			allChar[str1.charAt(i)]++;
			allChar[str2.charAt(i)]--;
		}
		for (int i=0; i<str1.length(); i++){
			if(allChar[i]!=0){
				return false;
			}
		}
		return true;
	}
*/