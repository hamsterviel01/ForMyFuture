
public class Excercise2 {
	public static String longestCommonSubsequence(String str1, String str2){
		String[][] cache = new String[str1.length()+1][str2.length()+1];
		String maxString = "";
		
		for (int i=0; i<=str1.length(); i++){
			cache[i][0] = "";
		}
		
		for (int j=1; j<=str2.length(); j++){
			cache[0][j] = "";
		}
		
		for (int i=1; i<=str1.length(); i++){
			for (int j=1; j<=str2.length(); j++){
				if (str1.charAt(i-1) == str2.charAt(j-1)){
					cache[i][j] = cache[i-1][j-1] + str1.charAt(i-1);
				} else {
					cache[i][j] = cache[i-1][j].length() > cache[i][j-1].length() ? cache[i-1][j] : cache[i][j-1];
				}
				if (maxString.length() < cache[i][j].length()){
					maxString = cache[i][j];
				}
			}
		}
		
		return maxString;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubsequence("abdelghadegop", "adlkegjihoop"));
		System.out.println(longestCommonSubsequence("", "adlkegjihoop"));
		System.out.println(longestCommonSubsequence("", ""));
		System.out.println(longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaa"));
		System.out.println(longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaa", "bbbbbbbbbb"));
	}

}
