import java.util.*;

public class Section9DynamicProgrammingEx5 {
	public static ArrayList<String> allPermutation(String str){
		if (str == null){
			return null;
		}
		
		ArrayList<String> newPermu = new ArrayList<String>();
		if (str.length() == 0){
			newPermu.add("");
			return newPermu;
		}
		
		char firstChar = str.charAt(0);
		ArrayList<String> permu = allPermutation(str.substring(1));
		for (String word: permu){
			for (int i=0; i<=word.length(); i++){
				String temp = insertAtIndex(word, i, firstChar);
				newPermu.add(temp);
			}
		}
		
		return newPermu;
	}
	
	public static String insertAtIndex(String str, int index, char c){
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0, index));
		sb.append(c);
		sb.append(str.substring(index));
		return sb.toString();
	}
	
	public static void main(String[] args){
		ArrayList<String> temp = allPermutation("abc");
		System.out.println(temp.size());
		System.out.println(temp);
	}
}