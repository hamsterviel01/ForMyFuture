import java.util.*;

public class WorksApplicationsExcercise4 {
 	public static boolean validateParantheses(String str){
 		if (str.length()%2 == 1) return false;
		if (str.equals("")) return true;
		if (str.charAt(0) == '}') return false;

 		Stack<Character> stack = new Stack<Character>();
 		for (int i=0; i<str.length(); i++){
 			if (str.charAt(i) == '{'){
 				stack.push('{');
 			} else if (str.charAt(i) == '}') {
 				if (stack.isEmpty()){
 					return false;
 				}
 				stack.pop();
 			} else {
 				return false;
 			}
 		}

 		if (stack.isEmpty()) return true;
 		return false;
 	}

	public static void main(String[] args){
		System.out.println(validateParantheses("{{{{{{{{{{}}}}}}}}}}}{{}{}}"));
	}
}