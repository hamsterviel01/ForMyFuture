/**This is similar to fing longest increasing subsequence, but simpler*/

public class WorksApplicationsExcercise13 {
	public static String longestIncreasingSubstring(String input){
		String[] cache = new String[input.length()];
		cache[0] = String.valueOf(input.charAt(0));
		int maxIndex = 0;

		for (int i=1; i<input.length(); i++){
			char temp = input.charAt(i);
			StringBuilder sb = new StringBuilder();
			sb.insert(0, temp);
			if (temp > input.charAt(i-1)){
				sb.insert(0, cache[i-1]);
			}
			cache[i] = sb.toString();
			if (cache[i].length() > cache[maxIndex].length()){
				maxIndex = i;
			}
		}

		return cache[maxIndex];
	}

	public static void main(String[] args){
		System.out.println(longestIncreasingSubstring("ghjklabedefghik"));
	}
}