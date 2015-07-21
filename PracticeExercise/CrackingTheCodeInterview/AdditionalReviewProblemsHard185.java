/**
Solution:
	1. Store each word in a Hashtable<key=word, positionsInText=int[]> -> time complexity: O(n);
	2. Since positionsInText is auto sorted ascendingly --> find smallest distance between 2 words take only O(m) where m - min(length of 2 positionsInText);
*/
import java.util.*;

public class AdditionalReviewProblemsHard185 {
	public static int distanceBetweenTwoWords(String input, String from, String to){
		Hashtable<String, ArrayList<Integer>> wordMap = mapAllWord(input);

		if (wordMap.containsKey(from) && wordMap.containsKey(to)){
			ArrayList<Integer> fromPos = wordMap.get(from);
			ArrayList<Integer> toPos = wordMap.get(to);
			int[] result = findSmallestDistance(fromPos, toPos);

			System.out.println(result[0] + " " + result[1]);
			if (result[1] == 1){
				return result[0] - from.length();
			} else {
				return result[0] - to.length();
			}
		} else {
			return -1;
		}
	}

	//This can be improved by merging 2 array together, add one additional array to contain value of where element are from fromPos or from toPos.
	public static int[] findSmallestDistance(ArrayList<Integer> fromPos, ArrayList<Integer> toPos){
		int min = Integer.MAX_VALUE;
		int isFrom = 1; //This variable will tell us the word go before will be "from" string or "to" string
		for (int i=0; i < fromPos.size(); i++){
			int localMin = Integer.MAX_VALUE;
			int localIsFrom = 1;
			int j=0;
			while (j < toPos.size() && localMin > Math.abs(fromPos.get(i) -  toPos.get(j))){
				localMin = Math.abs(fromPos.get(i) -  toPos.get(j));
				if (toPos.get(j) < fromPos.get(i)){
					localIsFrom = 0;
				} else {
					localIsFrom = 1;
				}
				j++;
			}

			if (localMin < min){
				min = localMin;
				isFrom = localIsFrom;
			}
		}

		return new int[]{min, isFrom};
	}

	public static Hashtable<String, ArrayList<Integer>> mapAllWord(String input){
		Hashtable<String, ArrayList<Integer>> wordMap = new Hashtable<String, ArrayList<Integer>>();

		int i = 0;
		while (i < input.length()){
			int j=i;
			StringBuilder strBuilder = new StringBuilder();
			while (j < input.length() && !(input.charAt(j) == ' ' || input.charAt(j) == '\n')){
				strBuilder.append(input.charAt(j));
				j++;
			}
			
			if (strBuilder != null){
				String str = strBuilder.toString();
				if (!wordMap.containsKey(str)){
					wordMap.put(str, new ArrayList<Integer>());
				}
				wordMap.get(str).add(i);
				i=j+1;
			} else {
				i++;
			}
		}

		return wordMap;
	}

	public static void main(String[] args){
		String input = "It can also be argued that DNA is nothing more than a program designed to preserve itself. Life has become more complex in the overwhelming sea of information. And life, when organized into species, relies upon genes to be its memory system. So, man is an individual only because of his intangible memory... and memory cannot be defined, but it defines mankind. The advent of computers, and the subsequent accumulation of incalculable data has given rise to a new system of memory and thought parallel to your own. Humanity has underestimated the consequences of computerization.\nThere are countless ingredients that make up the human body and mind, like all the components that make up me as an individual with my own personality. Sure I have a face and voice to distinguish myself from others, but my thoughts and memories are unique only to me, and I carry a sense of my own destiny. Each of those things are just a small part of it. I collect information to use in my own way. All of that blends to create a mixture that forms me and gives rise to my conscience. I feel confined, only free to expand myself within boundaries.\nPuppet Master: I refer to myself as an intelligent life form because I am sentient and I am able to recognize my own existence, but in my present state I am still incomplete. I lack the most basic processes inherent in all living organisms: reproducing and dying.";

		Hashtable mapAllWord = mapAllWord(input);
		String from = "memory";
		String to = "be";

		System.out.println(mapAllWord.get(from));
		System.out.println(mapAllWord.get(to));
		System.out.println(distanceBetweenTwoWords(input, from, to));
	}
}