import java.util.*;

//Time complexity O(m*n), space complexity O(m*n)

public class WorksApplication20150716Excercise1 {
	public static String longestSubstring(String shortStr, String longStr){
		Hashtable<Character, ArrayList<Integer>> charMap = new Hashtable<Character, ArrayList<Integer>>();
		//This map will keep pair of char that has been compared and included: a1a1, a1a3, b4b5, etc.
		HashSet<String> visitMap = new HashSet<String>();

		//Store max substring
		int maxLength = 0;
		StringBuilder maxString = new StringBuilder();

		//Put all char into a hashtable for fast look up of its positions.
		for (int i=0; i<longStr.length(); i++){
			if (charMap.containsKey(longStr.charAt(i))){
				charMap.get(longStr.charAt(i)).add(i);
			} else {
				charMap.put(longStr.charAt(i), new ArrayList<Integer>(Arrays.asList(i)));
			}
		}

		//Run across short string
		for (int i=0; i<shortStr.length(); i++){
			//char at shortStr = char at longStr
			if (charMap.containsKey(shortStr.charAt(i))){
				ArrayList<Integer> positions = charMap.get(shortStr.charAt(i));
				for (int j=0; j<positions.size(); j++){
					int k = positions.get(j);
					int tempPointer = i;
					String temp = String.valueOf(shortStr.charAt(tempPointer)) + String.valueOf(tempPointer) + String.valueOf(longStr.charAt(k)) + String.valueOf(k);
					if (visitMap.contains(temp)){
						break;	
					} else {
						StringBuilder strBuilder = new StringBuilder();
						while (tempPointer < shortStr.length() && k < longStr.length() && shortStr.charAt(tempPointer) == longStr.charAt(k)){
							strBuilder.append(String.valueOf(shortStr.charAt(tempPointer)));
							visitMap.add(temp);
							tempPointer++;
							k++;
						}
						//Check if new substring is max
						if (strBuilder.length() > maxLength){
							maxLength = strBuilder.length();
							maxString = strBuilder;
						}
					}
				}
			}
		}

		return maxString.toString();
	}

	//Another solution run on O(m*n), using dynamic programing, same complexity but cleaner code, faster performance due to less string manipulation
	public static String longestSubstring1(String str1, String str2){
		if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) return "";	
		int[][] table = new int[str1.length()][str2.length()];
		int maxLength = 0;
		int lastSubBegin = 0;
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<str1.length(); i++){
			for (int j=0; j<str2.length(); j++){
				if (str1.charAt(i) == str2.charAt(j)){
					if (i==0 || j==0){
						table[i][j] = 1;
					} else {
						table[i][j] = 1 + table[i-1][j-1];
					}

					if (table[i][j] > maxLength){
						maxLength = table[i][j];
						int thisSubBegin = i - table[i][j] + 1;
						if (thisSubBegin == lastSubBegin){
							//if the current LCS is the same as the last time this block ran
							sb.append(String.valueOf(str1.charAt(i)));
						} else {
							//If the this new position was part of larger substring --> abandon current string builder.
							sb = new StringBuilder();
							//Why i + 1????? --> substring[start, end) 
							sb.append(str1.substring(thisSubBegin, i+1));
							lastSubBegin = thisSubBegin;
						}
					}
				}				
			}
		}

		printTable(str1, str2, table);

		return sb.toString();
	}


	//ultility function
	public static void printTable(String str1, String str2, int[][] table){
		System.out.printf("%2s", " ");
		for (int j=0; j<str2.length(); j++) {
			System.out.printf("%1s%1d", str2.charAt(j), j);
		}
		System.out.println();
		for (int i=0; i<str1.length(); i++){
			System.out.printf("%-1s%1d", str1.charAt(i), i);
			for (int j=0; j<str2.length(); j++){
				System.out.printf("%2d", table[i][j]);
			}
			System.out.println();
		}
	}


	public static void main(String[] args){
		System.out.println(longestSubstring("abcdeefghaik", "deefgabcikltegeefghaik"));
		System.out.println(longestSubstring1("cabaaaafl", "bcaaaate"));
		System.out.println("cabaaaafl".substring(0, 0));
		//Worst case scenario
		//System.out.println(longestSubstring("eeeeeeeeee", "eeeeeeeeeeeeeeeeeeeeeeeeee"));
	}
}