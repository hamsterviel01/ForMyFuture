import java.util.*;

public class RecursionAndDynamicProgramming95 {
	public static HashSet<String> printAllPermutation(String input, int endIndex, HashSet<String> allPermutation){
		Iterator<String> it = allPermutation.iterator();
		HashSet<String> allNewPermutation = new HashSet<String>();
		if (endIndex < input.length()){
			char c = input.charAt(endIndex);
			while (it.hasNext()){
				String str = it.next();
				for (int i = 0; i<endIndex-1; i++){
					String newPermu = str.substring(0, i) + c +str.substring(i+1, endIndex-1);
					allNewPermutation.add(newPermu);
				}
			}
			printAllPermutation(input, endIndex+1, allNewPermutation);
		}
		return allNewPermutation;	
	}

	public static HashSet<String> allPermutation(String input){
		HashSet<String> allPermutation = new HashSet<String>();
		if (input.length() == 0 || input.length() == 1){
			allPermutation.add(input);
			return allPermutation;
		}
		allPermutation.add(String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(1)));
		allPermutation.add(String.valueOf(input.charAt(1)) + String.valueOf(input.charAt(0)));
		if (input.length() == 2){
			return allPermutation;
		} 

		return printAllPermutation(input, 2, allPermutation);
	}

	public static void main(String[] args){
		System.out.println(allPermutation("abcde"));
	}
}