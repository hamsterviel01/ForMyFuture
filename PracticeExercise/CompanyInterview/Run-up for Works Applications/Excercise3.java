
public class Excercise3 {
	public static String convertString(String input){
		if (input == null) return null;
		if (input.length() < 3) return input;
		
		char c = input.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=input.length(); i++){
			if (i<input.length() && input.charAt(i) == c){
				count++;
			} else {
				if (count > 2){
					sb.append(c + String.valueOf(count));
				} else {
					while (count > 0){
						sb.append(c);
						count--;
					}
				}
				
				if (i<input.length()){
					c = input.charAt(i);
					count = 1;
				}
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertString("aaabbccccccccdd"));
		System.out.println(convertString("aaabbcccd"));
		System.out.println(convertString(""));
		System.out.println(convertString(null));
		System.out.println(convertString("a"));
		System.out.println(convertString("aaa"));
		System.out.println(convertString("aa"));
	}

}
