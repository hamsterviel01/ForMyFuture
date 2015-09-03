import java.util.*;
import java.io.*;

public class DynamicProgrammingSet12 {
	public static int longestPalindrome(char[] str, int start, int end, int[][] cache){
		if (start > end) return 0;
		if (cache[start][end] != 0){
			return cache[start][end];
		}
		if (start == end) {
			cache[start][end] = 1;
			return 1;
		}

		if (str[start] == str[end]){
			if (start+1 == end){
				cache[start][end] = 2;
				return 2;
			} else {
				cache[start][end] = longestPalindrome(str, start+1, end-1, cache) + 2; //how about bb case
				return cache[start][end];
			}
		}

		//if (str[start] != str[end]){ 
		return Math.max(longestPalindrome(str, start+1, end, cache), longestPalindrome(str, start, end-1, cache));
	}

	public static int longestPalindrome(String str){
		char[] charArr = str.toCharArray();
		int[][] cache = new int[str.length()][str.length()];

		if (charArr.length == 0 || charArr.length == 1) return charArr.length;
		return longestPalindrome(charArr, 0, charArr.length-1, cache);
	}

	public static void main(String[] args){
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = rd.readLine();
			System.out.println(longestPalindrome(str));
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				rd.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}