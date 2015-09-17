
public class Excercise13 {
	public static String longestIncreaseSubstring(String str){
		if (str == null || str.length() == 0) return null;
		if (str.length() == 1) return str;
		String[] cache = new String[str.length()];
		cache[0] = String.valueOf(str.charAt(0));
		StringBuilder maxString = new StringBuilder();
		
		for (int i=1; i<str.length(); i++){
			if (str.charAt(i) > cache[i-1].charAt(cache[i-1].length()-1)){
				cache[i] = cache[i-1] + str.charAt(i);
			} else {
				cache[i] = String.valueOf(str.charAt(i));
			}
			if (maxString.length() < cache[i].length()){
				maxString = new StringBuilder();
				maxString.append(cache[i]);
			}
		}
		
		return maxString.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestIncreaseSubstring("hcdabcdeibcdefghikj"));
		System.out.println(longestIncreaseSubstring(""));
		System.out.println(longestIncreaseSubstring("h"));
	}

}
