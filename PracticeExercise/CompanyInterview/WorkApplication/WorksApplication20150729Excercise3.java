public class WorksApplication20150729Excercise3 {
	public static String shortenString(String input){
		if (input == null || input.isEmpty()) return "";
		char previousChar = input.charAt(0);
		int previousCount = 1;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<input.length(); i++){
			if (input.charAt(i) == previousChar){
				previousCount++;
				if (i==input.length()-1){
					sb.append(input.charAt(i) + String.valueOf(previousCount));
				}
			} else {
				previousChar = input.charAt(i);
				if (previousCount == 1){
					sb.append(input.charAt(i-1));
				} else {
					sb.append(input.charAt(i-1) + String.valueOf(previousCount));
					previousCount = 1;
				}
				if (i==input.length()-1){
					sb.append(input.charAt(i));
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args){
		System.out.println(shortenString("aaabbaacndfddffff"));
		System.out.println(shortenString("aaabbaacndfddffffa"));
		System.out.println(shortenString("aaabbaacndfddffffab"));
	}
}