public class WorksApplicationsExcercise2 {
	public static int findLongestCommonSubsequence(String str1, String str2){
		int[][] cache = new int[str1.length()+1][str2.length()+1];

		int max = 0;
		for (int i=1; i<str1.length()+1; i++){
			for (int j=1; j<str2.length()+1; j++){
				if (str1.charAt(i-1) == str2.charAt(j-1)){
					cache[i][j] = cache[i-1][j-1] + 1;
					if (max < cache[i][j]){
						max = cache[i][j];
					}
				} else {
					cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
				}
			}
		}

		return max;
	}

	public static void main(String[] args){
		String str1 = "abbeda";
		String str2 = "ccbccdcca";
		System.out.println(findLongestCommonSubsequence(str1, str2));
	}
}