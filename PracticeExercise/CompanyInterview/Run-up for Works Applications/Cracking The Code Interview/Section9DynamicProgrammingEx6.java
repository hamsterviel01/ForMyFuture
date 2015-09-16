import java.util.*;

public class Section9DynamicProgrammingEx6 {
	// This is inefficient solution, generate many duplicated string
	// public static HashSet<String> generateAllValidParentheses(int n){
	// 	if (n==1) {
	// 		return new HashSet<String>(Arrays.asList("()"));
	// 	}
	// 	HashSet<String> oldSet = generateAllValidParentheses(n-1);
	// 	HashSet<String> newSet = new HashSet<String>();
	// 	for (String str: oldSet){
	// 		for (int i=0; i<str.length(); i++){
	// 			StringBuilder sb = new StringBuilder();
	// 			sb.append("(");
	// 			sb.append(str.substring(0, i));
	// 			sb.append(")");
	// 			sb.append(str.substring(i));
	// 			newSet.add(sb.toString());
	// 		}
	// 	}
	// 	return newSet;
	// }
	
	public static ArrayList<String> allValidParentheses(int n){
		if (n==0) return null;
		char[] str = new char[n*2];
		ArrayList<String> result = new ArrayList<String>();
		addParen(result, 0, 0, str);
		return result;
	}
	
	public static void addParen(ArrayList<String> result, int noOfLeftParen, int noOfRightParen, char[] str){
		if (noOfLeftParen > str.length/2 || noOfLeftParen < noOfRightParen) return;
		
		if (noOfLeftParen == noOfRightParen && noOfRightParen == str.length/2){
			String string = String.copyValueOf(str);
			result.add(string);
			return;
		}
		
		int currentPos = noOfLeftParen + noOfRightParen;
		str[currentPos] = '(';
		addParen(result, noOfLeftParen+1, noOfRightParen, str);
		str[currentPos] = ')';
		addParen(result, noOfLeftParen, noOfRightParen+1, str);
	}
	
	public static void main(String[] args){
		System.out.println(allValidParentheses(3));
	}
}	