import java.util.*;

public class SortingAndSearching12 {
	//Use LinkedHashMap to check if current string was already contained inside sorted list 
	public static String[] sortArrayString(String[] stringArray){
		String[] newStringArray = new String[stringArray.length];
		int newIndex = 0;
		int endIndex = stringArray.length -1;
		for(int i=0; i<stringArray.length; i++){
			if (stringArray[i] != null){
				String temp = stringArray[i];
				stringArray[i] = null;
				newStringArray[newIndex] = temp;
				newIndex++;
				for (int j=0; j<stringArray.length; j++){
					if (stringArray[j] != null && j != i){
						if (isAnagram(temp, stringArray[j])){
							//we need to know if stringArray[i] has 
							newStringArray[newIndex] = stringArray[j];
							newIndex++;
							stringArray[j] = null;
						}
					}
				}
			}
		}
		return newStringArray;
	}

	//Runtime - 2n, space - 1, efficient if the strings are long (>= 16 chars)
	public static boolean isAnagram(String str1, String str2){
		if (str1.length() != str2.length()){
			return false;
		}
		int[] allChar = new int[256];
		for (int i=0; i<str1.length(); i++){
			allChar[str1.charAt(i)]++;
			allChar[str2.charAt(i)]--;
		}
		for (int i=0; i<str1.length(); i++){
			if(allChar[i]!=0){
				return false;
			}
		}
		return true;
	}

	//Runtime - nlog n
	public static boolean isAnagramSort(String str1, String str2){
		if (str1.length() != str2.length()){
			return false;
		}
		char[] str1Array = mergeSort(str1.toCharArray());
		char[] str2Array = mergeSort(str2.toCharArray());

		return Arrays.equals(str1Array, str2Array);
	}

	public static char[] mergeSort(char[] str){
		return null;
	}

	public static void main(String[] args){
		String[] stringArray = new String[]{"asdccab", "adfd", "dffs", "sdddss", "sdacbac", "sdsdsd", "cabdsac", "assdf"};
		String[] newStringArray = sortArrayString(stringArray);
		for (int i=0; i<newStringArray.length; i++){
			System.out.print(newStringArray[i] + "; ");
		}
		System.out.println();
	}
}