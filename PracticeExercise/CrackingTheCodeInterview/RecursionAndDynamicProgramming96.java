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
				for (int j=i+1; j<str.length(); j++){
					newSet.add(insertChar(str, i, j));
				}
				newSet.add(str.substring(0, i) + "(" + str.substring(i) + ")");
			}
			newSet.add(str + "()");
		}
		return newSet;
	}

	public static String insertChar(String str, int i, int j){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(str.substring(0, i));
		strBuilder.append("(");
		strBuilder.append(str.substring(i,j));
		strBuilder.append(")");
		strBuilder.append(str.substring(j));
		return strBuilder.toString();
	}

	public static void main(String[] args){
		HashSet<String> set = printAllParenthese(4);
		int count = 0;
		for (String str: set){
			count++;
		}
		System.out.println(set);
		System.out.println(count);
	}
}