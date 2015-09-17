
public class Excercise5 {
	//check if str1 is substring of str2
	public static boolean isSubstring(String str1, String str2){
		if (str1.length() > str2.length()) return false;
		if (str1.equals(str2)) return true;
		if (str1 == "" || str1 == null) return false;
		
		for (int i=0; i<str2.length() - str1.length(); i++){
			if (str2.charAt(i) == str1.charAt(0)){
				int j = i;
				int k = 0;
				while (j < str2.length() && k<str1.length() && str2.charAt(j) == str1.charAt(k)){
					j++;
					k++;
				}
				if (k == str1.length()) return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSubstring("bcdef", "abcdefgh"));
		System.out.println(isSubstring("bcdefh", "abcdefgh"));
		System.out.println(isSubstring("b", "abcdefgh"));
		System.out.println(isSubstring("", "abcdefgh"));
		System.out.println(isSubstring("abcdefgh", "abcdef"));
		System.out.println(isSubstring("aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}

}
