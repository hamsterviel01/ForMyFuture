import java.util.Stack;

public class Excercise4 {
	public static boolean validateSequence(String input){
		if (input == null || input.length() == 0) return false;
		if (input.charAt(0) != '{') return false;
		Stack<Character> open = new Stack<Character>();
		
		for (int i=0; i<input.length(); i++){
			if (input.charAt(i) == '{'){
				open.push('{');
			} else if (input.charAt(i) == '}'){
				if (open.empty()){
					return false;
				}
				open.pop();
			} else {
				return false;
			}
		}
		
		if (!open.isEmpty()){
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{{{}{}}}
		System.out.println(validateSequence("{{{}{}}}{}{{}}{{{}}}"));
		System.out.println(validateSequence("{{{}{}{}}"));
		System.out.println(validateSequence("}{{{}{}}}"));
		System.out.println(validateSequence("{}{{}{}}}"));
		System.out.println(validateSequence(""));
	}

}
