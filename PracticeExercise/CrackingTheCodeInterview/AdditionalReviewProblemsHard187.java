/**

*/

import java.util.*;

public class AdditionalReviewProblemsHard187 {
	//Time complexity O(n*n)
	public static String getLongestString(String[] input){
		//Using hashset to filter out duplicated element inside input --> caused this algo to never return false
		Hashtable<Character, HashSet<String>> mapString = new Hashtable<Character, HashSet<String>>();
		int maxLength = 0;
		int maxIndex = -1;

		//Store first char as K and all of String which start with this char as V
		for (int i=0; i<input.length; i++){
			char c = input[i].charAt(0);
			if (mapString.containsKey(c)){
				mapString.get(c).add(input[i]);
			} else {
				mapString.put(c, new HashSet<String>(Arrays.asList(input[i])));
			}
		}

		for (int i=0; i<input.length; i++){
			if (maxLength < input[i].length()){
				//First need to make sure mapString don't contain input[i]
				mapString.get(input[i].charAt(0)).remove(input[i]);
				if (isBuiltByComponentString(input[i], mapString)){
					maxLength = input[i].length();
					maxIndex = i;
				}
				mapString.get(input[i].charAt(0)).add(input[i]);
			}
		}

		if (maxIndex == -1){
			return null;
		} 
		return input[maxIndex];
	}

	//Recursive to look for string.
	public static boolean isBuiltByComponentString(String str, Hashtable<Character, HashSet<String>> mapString){
		if (mapString.containsKey(str.charAt(0))) {
			if (mapString.get(str.charAt(0)).contains(str)){
				return true;
			} else {
				HashSet<String> list = mapString.get(str.charAt(0));

				//do recursion isBuiltByComponentString for each element in list
				Iterator<String> it = list.iterator();
				while(it.hasNext()){
					//check if list.get(i) match with str
					String temp = it.next();

					//if list.get(i) matched with str
					if (temp.length() <= str.length()){
						boolean moveNext = false;
						for (int j=0; j<temp.length(); j++){
							if (temp.charAt(j) != str.charAt(j)){
								//move to next element in the list.
								moveNext = true;
								break;
							}
						}
						if (!moveNext){
							//stopping conditions --> if one of them is true --> all is true
							if (isBuiltByComponentString(str.substring(temp.length()), mapString)) return true;
						}
					}
				}

				//if non of element is list is builtByComponentString --> return false as this str is 
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args){
		String[] input = new String[]{"defgh", "de", "def", "dedefgh", "abc"};
		String[] input1 = new String[]{"defgh", "de", "def", "abc", "dedefgh", "dedefgh", "abc", "abe", "abcdefdefgh", "fde", "abcdefdefghfg"};
		System.out.println(getLongestString(input1));
	}
}

/**From Cracking the Code Interview*/
	// public static String getLongestString1(String arr[]) {
	// 	HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	// 	for (String str : arr) {
	// 		map.put(str, true);
	// 	}
	// 	Arrays.sort(arr, new LengthComparator()); // Sort by length
	// 	for (String s : arr) {
	// 		if (canBuildWord(s, true, map)) {
	// 			System.out.println(s);
	// 			return s;
	// 		}
	// 	}
	// 	return "";
	// }

	// public static boolean canBuildWord(String str, boolean isOriginalWord, HashMap<String, Boolean> map) {
	// 	if (map.containsKey(str) && !isOriginalWord) {
	// 		return map.get(str);
	// 	}

	// 	for (int i = 1; i < str.length(); i++) {
	// 		String left = str.substring(0, i);
	// 		String right = str.substring(i);
	// 		if (map.containsKey(left) && map.get(left) == true && canBuildWord(right, false, map)) {
	// 			return true;
	// 		}
	// 	}
	// 	map.put(str, false);
	// 	return false;
	// }