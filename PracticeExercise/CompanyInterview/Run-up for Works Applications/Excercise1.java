
public class Excercise1 {
	public static String longestSubstring(String str1, String str2){
		if (str1.length() == 0 || str2.length() == 0) return "";
		int[][] cache = new int[str1.length()+1][str2.length()+1];
		int max = -1;
		int maxIndexI = -1;
		
		for (int i=1; i<=str1.length(); i++){
			for (int j=1; j<=str2.length(); j++){
				if (str1.charAt(i-1) == str2.charAt(j-1)){
					cache[i][j] = cache[i-1][j-1] + 1;
				}
				if (max < cache[i][j] && cache[i][j] != 0){
					max=cache[i][j];
					maxIndexI = i;
				}
			}
		}
		
		if (max == -1) return "";
		return str1.substring(maxIndexI - max, maxIndexI);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubstring("aabcdeaaaabcdeaaaabcdeaa", "ababcdeaababcdeaababcdeaababcdeaababcdeaababcdeaababcdea"));
		System.out.println(longestSubstring("", "ababcdea"));
		System.out.println(longestSubstring("ghiklm", "ababcdea"));
		System.out.println(longestSubstring("", ""));
	}
}
