public class DynamicProgrammingSet5 {
	public static int minimumEditDistance(String str1, String str2, int m, int n, int[][] cache){
		if (m < 0 && n < 0){
			return 0;
		}
		if (m < 0){
			return n;
		}
		if (n < 0){
			return m;
		}
		if (cache[m][n] != -1){
			return cache[m][n];
		}
		if (str1.charAt(m) == str2.charAt(n)){
			cache[m][n] = minimumEditDistance(str1, str2, m-1, n-1, cache);
			return cache[m][n];
		}
		cache[m][n] = 1 + Math.min(Math.min(minimumEditDistance(str1, str2, m-1, n-1, cache), minimumEditDistance(str1, str2, m, n-1, cache)), 
				minimumEditDistance(str1, str2, m-1, n, cache));
		return cache[m][n];
	}
	
	public static int minimumEditDistance(String str1, String str2){
		int[][] cache = new int[str1.length()][str2.length()];
		for (int i=0; i<str1.length(); i++){
			for (int j=0; j<str2.length(); j++){
				cache[i][j] = -1;
			}
		}
		return minimumEditDistance(str1, str2, str1.length()-1, str2.length()-1, cache);
	}
	
	public static void main(String[] args){
		String str1 = "aaabbaa";
		String str2 = "aaaabbbaaa";
		System.out.println(minimumEditDistance(str1, str2));
	}
}