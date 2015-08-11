import java.util.*;

public class RecursionAndDynamicProgramming94 {
	//deal with subset with unique elements first.
	public static ArrayList<String> returnSubset(String input, int end){
		ArrayList<String> allSubsets = new ArrayList<String>();
		if (end == 0){
			allSubsets.add(String.valueOf(input.charAt(0)));
			return allSubsets;
		}
		ArrayList<String> oldSubsets = returnSubset(input, end-1);
		for (String str: oldSubsets){
			allSubsets.add(str);
			allSubsets.add(str + input.charAt(end));
		}
		return allSubsets;
	}

	public static void main(String[] args){
		String input = "abcdd";
		System.out.println(returnSubset(input, input.length()-1));
	}
}