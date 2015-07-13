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
	/**Bottom up Approach*/
	public static void printAllPermutation(String input, int endIndex, HashSet<String> allPermutation){
		HashSet<String> allNewPermutation = new HashSet<String>();
		if (endIndex < input.length()){
			char c = input.charAt(endIndex);
			for (String str: allPermutation){
				for (int i = 0; i<=endIndex-1; i++){
					String newPermu = str.substring(0, i) + c +str.substring(i);
					allNewPermutation.add(newPermu);
				}
				allNewPermutation.add(str + c);
			}
			allPermutation.clear();
			for (String str: allNewPermutation){
				allPermutation.add(str);
			}
			printAllPermutation(input, endIndex+1, allPermutation);
		}
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

		printAllPermutation(input, 2, allPermutation);
		return allPermutation;
	}

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
		String word = input.substring(1);
		char c = input.charAt(0);
		HashSet<String> newPermutations = generateAllPermutation(word);
		for (String permu: newPermutations){
			for(int i=0; i<permu.length(); i++){
				permutations.add(insertChar(permu, c, i));
			}
			permutations.add(permu + c);
		}
		return permutations;
	}

	public static void main(String[] args){
		HashSet<String> set = generateAllPermutation("abcd");
		int count = 0;
		for (String str: set){
			count++;
		}
		System.out.println(set);
		System.out.println(count);
	}
}