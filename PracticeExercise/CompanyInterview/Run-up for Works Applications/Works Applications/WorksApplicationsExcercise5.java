public class WorksApplicationsExcercise5 {
	public static boolean isSubstring(String str1, String str2){
		if (str1.length() > str2.length()) return false;
		if (str1 == "") return false;

		int i = 0;
		for (int j=0; j<str2.length(); j++){
			if (str1.charAt(i) == str2.charAt(j)){
				if (i == str1.length() - 1) return true;
				i++;
			} else {
				i = 0;
				if (str1.charAt(i) == str2.charAt(j)){
					i++;
				}
			}
		}

		return false;
	}

	public static void main(String[] args){ 
		System.out.println(isSubstring("a", "babbdfsdfsd"));
		System.out.println(isSubstring("b", "werqewfqwgb"));
		System.out.println(isSubstring("abbaa", "dddbbbaaabaabaabbbabba"));
	}
}