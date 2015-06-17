/**
* Time Complexity O(n^2)
*/

import java.io.*;

//Considering speed is the foremost piority, oh forget it, just set them to 0
//Do I need to maintain this 2 string -> no, then just update it
//Time Complexity: O(n^2)
public class ArrayAndString14 {
	public static boolean isAnagram1(char[] str1, char[] str2){
		//first if their size if not equal, or one of them has 1 character --> return false
		if (str1.length != str2.length || str1.length < 2 || str2.length < 2){
			return false;
		}

		//in case of 2 char??

		//Set an double linked list for these char[]
		int length = str1.length;

		//we start from str1
		for (int i=0; i<length; i++){
			int j;
			for (j=0; j<length; j++){
				if (str1[i] == str2[j]){
					str1[i] = 0;
					str2[j] = 0;
					break;
 				}
			}
			if (j==length){
				return false;
			}
		}
		return true;
	}

	//This will check the count of each unique character in each string
	//Asume all character is belong to Extended ASCII code table
	//Time Complexity: O(n) 
	public static boolean isAnagram2(String str1, String str2){
		if (str1.length() != str2.length() || str1.length() < 2 || str2.length() < 2) 
			return false;
		int length = str1.length();
		int[] charCount = new int[256];
		for (int i=0; i<256; i++){
			charCount[i] = 0;
		}

		for (int i=0; i<length; i++){
			charCount[str1.charAt(i)]++;
		}

		for (int i=0; i<length; i++){
			char temp = str2.charAt(i);
			int countTemp = charCount[temp];
			if(countTemp > 0){
				countTemp--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args){
		try {
			BufferedReader rd1 = new BufferedReader(new InputStreamReader(System.in));
			String str1 = rd1.readLine();

			BufferedReader rd2 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = rd2.readLine();

			System.out.println(isAnagram1(str1.toCharArray(), str2.toCharArray()));
			System.out.println(isAnagram2(str1, str2));
		} catch (IOException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}