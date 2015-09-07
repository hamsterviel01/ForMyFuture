import java.util.*;

public class Section9DynamicProgrammingEx6 {
	public static HashSet<String> generateAllValidParentheses(int n){
		
		if (n==1) {
			return new HashSet<String>(Arrays.asList("()"));
		}
		HashSet<String> oldSet = generateAllValidParentheses(n-1);
		HashSet<String> newSet = new HashSet<String>();
		for (String str: oldSet){
			for (int i=0; i<str.length(); i++){
				StringBuilder sb = new StringBuilder();
				sb.append("(");
				sb.append(str.substring(0, i));
				sb.append(")");
				sb.append(str.substring(i));
				newSet.add(sb.toString());
			}
		}
		return newSet;
	}

	public static void main(String[] args){
		System.out.println(generateAllValidParentheses(4));
	}
}