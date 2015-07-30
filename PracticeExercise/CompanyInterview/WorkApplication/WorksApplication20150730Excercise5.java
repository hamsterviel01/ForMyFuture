public class WorksApplication20150730Excercise5 {
	//Time Complexity O(m*n)
	public static boolean isSubstring(String str1, String str2){
		if (str2.length() > str1.length()) return false;
		if (str1.length() == str2.length() && !str1.equals(str2)) return false;
		if (str1.equals(str2)) return true;

		int i=0; 
		while (i<=(str1.length() - str2.length())){
			if (str1.charAt(i) == str2.charAt(0)){
				int j = i+1;
				int k = 1;
				int nextPointer = i+1;
				while (k < str2.length() && str1.charAt(j) == str2.charAt(k)){
					//To correc the case of "ddddf" is substring of "dddddddddf"
					if (str1.charAt(j) == str2.charAt(0) && nextPointer == i+1){
						nextPointer = j;
					}
					j++;
					k++;
				}

				System.out.println("k=" + k + " i=" + i);
				if (k == str2.length()){
					return true;
				}

				if (nextPointer > i+1){
					i = nextPointer;
				} else {
					i = i + k;
				}
			} else {
				i++;
			}
		}

		return false;
	}

	//Expands to find if string is subsequence of another str --> O(n) --> quite easy

	public static void main(String[] args){
		System.out.println(isSubstring("dddfdddfdddfdddfdddfdddfdddfdddf", "ddddf"));
	}
}