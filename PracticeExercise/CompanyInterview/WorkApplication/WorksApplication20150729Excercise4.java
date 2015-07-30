import java.util.*;

public class WorksApplication20150729Excercise4 {
	//Time complexity O(n^2)
	public static boolean validateBracketSequence(String brackets){
		return simplifyBracketSequence(brackets).isEmpty();
	}

	public static String simplifyBracketSequence(String brackets){
		if (brackets.isEmpty()) return "";
		if (brackets.charAt(brackets.length()-1) != '}' || brackets.charAt(0) != '{' || brackets.length()%2 != 0) return "}{";
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while(i < brackets.length()){
			if (brackets.charAt(i) == '{' && brackets.charAt(i+1) == '}'){
				i = i + 2;
			} else {
				sb.append(brackets.charAt(i));
				i++;
			}
		}

		return simplifyBracketSequence(sb.toString());
	}

	/**
	Solution from geekforgeek, time complexity O(n):
	- The essence of this algorithm is the observation that the string was validated if all opening bracket receiving an closed brackets
	It can be also extended to string that has "()", "[]" also.
	*/
	public static boolean validateBracketSequence1(String brackets){
		if (brackets.isEmpty()) return true;
		Hashtable<Character, Character> openAndClose = new Hashtable<Character, Character>();
		openAndClose.put('{', '}');
		openAndClose.put('(', ')');
		openAndClose.put('[', ']');
		if (!(openAndClose.containsKey(brackets.charAt(0)) && openAndClose.containsValue(brackets.charAt(brackets.length()-1)) && brackets.length()%2 == 0)) return false;
		Stack<Character> stack = new Stack<Character>();

		for (int i=0; i<brackets.length(); i++){
			if (openAndClose.containsKey(brackets.charAt(i))){
				stack.push(brackets.charAt(i));
			} else if (openAndClose.containsValue(brackets.charAt(i))){
				if (stack.isEmpty()){
					return false;
				} else if (brackets.charAt(i) == openAndClose.get(stack.peek())){
					stack.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		if (stack.isEmpty()){
			return true;
		} else {
			return false;
		}
	}


	public static void main(String[] args){
		System.out.println(validateBracketSequence1("[]{}{{}}((())){[()]}[]"));
	}
}