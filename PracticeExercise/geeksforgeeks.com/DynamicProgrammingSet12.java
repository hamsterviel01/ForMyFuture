import java.util.*;
import java.io.*;

public class DynamicProgrammingSet12 {
	//this need to be appoarch bottom up
	public static int longestPalindrome(char[] str, int start, int end, int[][] cache, boolean[][] isPalindrome){
		int[][] cache;
		
	}

	public static int longestPalindrome(String str){
		char[] charArr = str.toCharArray();
		int[][] cache = new int[str.length()][str.length()];
		boolean[][] isPalindrome = new boolean[str.length()][str.length()];

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