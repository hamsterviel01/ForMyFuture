public class SortingAndSearching12 {
	//Use LinkedHashMap to check if current string was already contained inside sorted list 
	public static String[] sortArrayString(String[] stringArray){
		String[] newStringArray = new String[stringArray.length];
		int newIndex = 0;
		for(int i=0; i<stringArray.length; i++){
			if (stringArray[i] != null){
				newStringArray[newIndex] = stringArray[i]++;
				for (int j=0; j<stringArray.length; j++){
					if (stringArray[j] != null){
						if (isAnagram(stringArray[i], stringArray[j])){
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

	//Runtime - 2n, space - n
	public static boolean isAnagram(String str1, String str2){
		if (str1.length() != str2.length()){
			return false;
		}
		int[] allChar = int[256];
		for (int i=0; i<str1.length(); i++){
			allChar[str1.charAt(i)]++;
			allChar[str2.charAt(i)]--;
		}
		for (int i=0; i<str1.length(); i++){
			if(allChar[i]!=0){
				return false;
			}
		}
	}
}