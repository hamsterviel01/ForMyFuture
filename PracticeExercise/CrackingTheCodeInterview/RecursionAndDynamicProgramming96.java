import java.util.*;

public class RecursionAndDynamicProgramming96 {
	public static HashSet<String> printAllParenthese(int n){
		HashSet<String> newSet = new HashSet<String>();
		if (n==1){
			newSet.add("()");
			return newSet;
		}
		HashSet<String> set = printAllParenthese(n-1);
		for (String str: set){
			for (int i=0; i<str.length(); i++){
				newSet.add(insertChar(str, i));
			}
		}
		return newSet;
	}

	public static String insertChar(String str, int i){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(str.substring(0, i));
		strBuilder.append("()");
		strBuilder.append(str.substring(i));
		return strBuilder.toString();
	}

	public static void main(String[] args){
		HashSet<String> set = printAllParenthese(3);
		System.out.println(set);
		System.out.println(set.size());
	}
}