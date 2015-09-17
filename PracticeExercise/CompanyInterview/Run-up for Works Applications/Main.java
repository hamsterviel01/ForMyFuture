import java.util.*;

public class Main {
	public static String longestPalindrome(String input){
		int[] palindromeLength = new int[input.length()];
		palindromeLength[0] = 1;
		if (input.charAt(1) == input.charAt(0)){
			palindromeLength[1] = 2;
		} else {
			palindromeLength[1] = 1;
		}
		
		int maxIndex = 0;
		for (int i=2; i<input.length(); i++){
			if (i-palindromeLength[i-1]-1 > -1 && input.charAt(i) == input.charAt(i-palindromeLength[i-1]-1)){
				palindromeLength[i] = palindromeLength[i-1] + 2;
			} else if (input.charAt(i) == input.charAt(i-1)){
				int j = i-1;
				while (j > -1 && input.charAt(j) == input.charAt(i)){
					j--;
				}
				palindromeLength[i] = i-j;
			} else {
				palindromeLength[i] = 1;
			}
			if (palindromeLength[i] > palindromeLength[maxIndex]){
				maxIndex = i;
			}
		}
		
		return input.substring(maxIndex-palindromeLength[maxIndex]+1, maxIndex+1);
	}
	
	public static void main(String[] args){
		System.out.println(longestPalindrome("habhhaaabaaad"));
	}
}