public class DynamicProgrammingSet17{
	public static int palindromePartitioning(String str, int start, int[] cache){
		if (start < str.length() && cache[start] != -1){
			return cache[start];
		}
		int minCut = str.length()-start-1;
		for (int i=start; i<str.length(); i++){
			if (str.charAt(start) == str.charAt(i)){
				if (isPalindrome(str.substring(start, i+1))){
					int noOfCut = 1 + palindromePartitioning(str, i+1, cache);
					if (noOfCut < minCut){
						minCut = noOfCut;
					}
				}
			}
			
		}
		return minCut;
	}

	public static int palindromePartitioning(String str){
		int[] cache = new int[str.length()];
		for (int i=0; i<cache.length; i++){
			cache[i] = -1;
		}
		return palindromePartitioning(str, 0, cache);
	}
	
	public static boolean isPalindrome(String str){
		int i=0;
		int j=str.length()-1;
		while (j > i && str.charAt(i) == str.charAt(j)){
			i++;
			j--;
		}
		if (i>=j){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		//result is wrong
		System.out.println(palindromePartitioning("ababbbabbababa"));
	}
}