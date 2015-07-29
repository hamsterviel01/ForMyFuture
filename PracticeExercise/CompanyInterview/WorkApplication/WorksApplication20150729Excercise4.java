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

	public static void main(String[] args){
		System.out.println(validateBracketSequence("{{}{{{}}}{}{}{{}}}}{{{{{}}}}{}{{}}{{{}}}"));
	}
}