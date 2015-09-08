public class DynamicProgrammingSet12 {
	//A simple O(n^2) kick-ass solution from leetcode
	public static String getLongestPalindrome(String str){
		StringBuilder max = new StringBuilder();
		//str.leng - 1 because we use i+1 later on and no way str.charAt(length - 1) is max value;
		for (int i=0; i<str.length()-1; i++){
			StringBuilder longest1 = expandAroundCenter(str, i, i);
			if (max.length() < longest1.length()){
				max = longest1;
			}
			StringBuilder longest2 = expandAroundCenter(str, i, i+1);
			if (max.length() < longest2.length()){
				max = longest2;
			}
		}
		
		return max.toString();
	}
	
	public static StringBuilder expandAroundCenter(String str, int c1, int c2){
		StringBuilder sb = new StringBuilder();
		while (c1 >= 0 && c2 < str.length() && str.charAt(c1) == str.charAt(c2)){
			if (c1 != c2){
				sb.insert(0, str.charAt(c1));
			}
			sb.append(str.charAt(c2));	
			c1--;
			c2++;
		}
		return sb;
	}
	
	public static void main(String[] args){
		System.out.println(getLongestPalindrome("aacdefbbababbbbbbbb"));
	}	
}