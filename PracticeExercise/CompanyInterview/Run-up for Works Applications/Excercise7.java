import java.util.ArrayList;


public class Excercise7 {
	public static ArrayList<String> allPermutation(String str){
		if (str.length() == 0 || str == null) return new ArrayList<String>();
		ArrayList<String> newPermus = new ArrayList<String>();
		if (str.length() == 1){
			newPermus.add(str);
			return newPermus;
		}
		String substr = str.substring(1);
		ArrayList<String> permus = allPermutation(substr);
		
		for (String permu: permus){
			for (int i=0; i<=permu.length(); i++){
				StringBuilder sb = new StringBuilder();
				sb.append(permu.substring(0, i));
				sb.append(str.charAt(0));
				sb.append(permu.substring(i));
				newPermus.add(sb.toString());
			}
		}
		
		return newPermus;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allPermutation(""));
		System.out.println(allPermutation("abc"));
		System.out.println(allPermutation("abcdefg").size());
		
	}

}
