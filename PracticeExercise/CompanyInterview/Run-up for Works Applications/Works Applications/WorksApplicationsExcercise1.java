import java.util.*;

/**
The pivot point of this problem is that there is no difference between longest common substring and longest common suffix (common string that comsume the last char of both str), since every common subtring was common suffix at certain m and n.

create a matrix of int[str1.length()+1][str2.length()+1], the reason for "+1" is because [i-1][j-1] at i, j = 0 will become -1
*/

public class WorksApplicationsExcercise1 {
	public static int findLongestCommonSubtring(String str1, String str2){
		int[][] longestSubstring = new int[str1.length()+1][str2.length()+1];

		int max = 0;
		for (int i=1; i<str1.length()+1; i++){
			for (int j=1; j<str2.length()+1; j++){
				if (str1.charAt(i-1) == str2.charAt(j-1)){
					longestSubstring[i][j] = longestSubstring[i-1][j-1] + 1;
					if (max < longestSubstring[i][j]){
						max = longestSubstring[i][j];
					}
				}
			}
		}

		return max;
	}

	//Follow-up, find longest substring appear more than 1
	/**Remember these line, dont just "-cache[i][j]", since its has its own substring.
		for (int count=0; count<=cache[i][j]; count++){
			String common = str1.substring(i-count, i);
	*/
	public static int findLongestCommonSubtringRepeat(String str1, String str2){
		int[][] cache = new int[str1.length()+1][str2.length()+1];
		HashMap<String, Boolean> appearList = new HashMap<String, Boolean>();

		int max = 0;
		for (int i=1; i<str1.length()+1; i++){
			for (int j=1; j<str2.length()+1; j++){
				if (str1.charAt(i-1) == str2.charAt(j-1)){
					cache[i][j] = 1 + cache[i-1][j-1];
					for (int count=0; count<=cache[i][j]; count++){
						String common = str1.substring(i-count, i);
						if (appearList.containsKey(common)){
							//appearList.put(common, true);
							if (max < common.length()){
								max = common.length();
							}
						} else {
							appearList.put(common, false);
						}
					}
				}
			}
		}

		for (int i=1; i<str1.length()+1; i++){
			for (int j=1; j<str2.length()+1; j++){
				System.out.print(" " + cache[i][j]);
			}
			System.out.println();
		}
		return max;
	}

	public static void main(String[] args){
		String str1 = "abbahgjjk";
		String str2 = "ahgbahgjjkghgjjk";
		System.out.println(findLongestCommonSubtringRepeat(str1, str2));
	} 
}