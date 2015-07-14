/**
Lession learnt:
- You can omit the certaind detail of excercise, leave it to user input, like last elemtn of array a and last element of array b to focus on the main part of algorithm
- The twist of copying element from the last was a clever solution to the problems of efficiency. I intend to solve this issue by 
*/

public class SortingAndSearching11 {
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int mergeIndex = indexA + indexB + 1;

		while (indexA >= 0 && indexB >= 0){
			if (a[indexA] >= b[indexB]){
				a[mergeIndex] = a[indexA];
				mergeIndex--;
				indexA--;
			} else {
				a[mergeIndex] = b[indexB];
				mergeIndex--;
				indexB--;
			}
		}

		while(indexB >= 0){
			a[mergeIndex] = b[indexB];
			mergeIndex--;
			indexB--;
		}
	}

	public static void main(String[] args){
		int[] a = new int[]{1, 2, 4, 5, 6, 7, 9, 0, 0, 0, 0, 0};
		int[] b = new int[]{2, 5, 6, 7, 8};

		merge(a, b, 7, 5);
		for (int i=0; i<a.length; i++){
			System.out.print(a[i] + " - ");
		}
	}
}