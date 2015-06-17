public class ArraysAndStrings11 {
	public static boolean isAllUniqueChar(String string){
		if (string.length() > 256) return false;
		boolean[] duplicateChar = new boolean[256];
		for (int i=0; i<string.length(); i++){
			if(duplicateChar[string.charAt(i)]){
				return false;
			}
			duplicateChar[string.charAt(i)] = true;
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(isAllUniqueChar("abdjdxkdmsne"));
		System.out.println(isAllUniqueChar("asdfghjklqwer;"));
	} 
}