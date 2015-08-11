import java.util.*;

/**
Lesson learnt in this exercise:
- There are 2 fundamental mistakes I made in this excercise 
	1. I didn't understand fully the functionality of substring(int, int) and substring(int) method
	2. For dynamic programing, there is 1 difference between bottom-up and top-down approach:
		+ Bottom-up: 
			- method need to pass to the higher method a container of result as an "parameter"
			- this approach was fairly limited because we have to manipulate 1 single container. 
		+ Top-down:
			- container of result can be pass through "return" statement
			- This approach is prefered because we can return a new container while we are passing down set of results.
	--> I was confused between these 2 method hence create a design that was neither this nor that.
*/

public class RecursionAndDynamicProgramming95 {
	/**Top Down approach*/
	public static String insertChar(String str, char c, int pos){
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(str.substring(0, pos));
		strBuilder.append(c);
		strBuilder.append(str.substring(pos));
		return strBuilder.toString();
	}

	public static HashSet<String> generateAllPermutation(String input){
		HashSet permutations = new HashSet<String>();
		if (input == ""){
			return null;
		}
		if (input.length() == 0 || input.length() == 1){
			permutations.add(input);
			return permutations;
		}
		char c = input.charAt(0);
		HashSet<String> newPermutations = generateAllPermutation(input.substring(1));
		for (String permu: newPermutations){
			for(int i=0; i<permu.length(); i++){
				permutations.add(insertChar(permu, c, i));
			}
			permutations.add(permu + c);
		}
		return permutations;
	}

	public static void main(String[] args){
		HashSet<String> set = generateAllPermutation("abcc");
		System.out.println(set.size());
		System.out.println(set);
	}
}