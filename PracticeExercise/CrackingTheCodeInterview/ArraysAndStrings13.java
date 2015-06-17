//Time complexity O(n)

public class ArraysAndStrings13 {
	public static boolean isPermutation(String str1, String str2){
		if (str1.length() != str2.length()) return false;

		//Asume string is ACSII code
		int[] charOccurence = new int[256];
		for (int i=0; i<str1.length(); i++){
			charOccurence[str1.charAt(i)]++;
		}
		for (int i=0; i<str1.length(); i++){
			if (charOccurence[str2.charAt(i)] == 0){
				return false;
			}
			charOccurence[str2.charAt(i)]--;
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(isPermutation("abcdefghik", "abcikghfed"));
		System.out.println(isPermutation("abcdefghik", "abcikghftd"));
		System.out.println(isPermutation("abcdefghik", "abcikkhfed"));
	}
}