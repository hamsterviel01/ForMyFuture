public class DynamicProgrammingSet5 {
	public static int minimumEditDistance(String str1, String str2){
		int[][] cache = new int[str1.length()+1][str2.length()+1];
		
		for (int i=0; i<=str1.length(); i++){
			for (int j=0; j<=str2.length(); j++){
				if (i == 0 || j == 0){
					cache[i][j] = Math.max(i, j);
				} else {
					if (str1.charAt(i-1) == str2.charAt(j-1)){
						cache[i][j] = cache[i-1][j-1];
					} else {
						cache[i][j] = 1 + Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1]);
					}
				}
			}
		}
		
		return cache[str1.length()][str2.length()];
	}
	
	public static void main(String[] args){
		String str1 = "aaabbaa";
		String str2 = "aaaabbbaaa";
		System.out.println(minimumEditDistance(str1, str2));
	}
}