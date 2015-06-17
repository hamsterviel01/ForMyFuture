//This require implementation in C++, so I just do alternate version in java

public class ArrayAndString12 {
	public static String reverse(String str){
		StringBuilder newStr = new StringBuilder();
		if (str == null) return null;
		for (int i = str.length()-1; i >= 0; i--){
			newStr.append(str.charAt(i));
		}
		return newStr.toString();
	}
	public static void main(String[] args){
		String str = "Tuan Anh";
		System.out.println(str);
		System.out.println(reverse(str));
	}
}