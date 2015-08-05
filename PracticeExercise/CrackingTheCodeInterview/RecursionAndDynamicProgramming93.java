/**
A magic index in an array A[l.. .n-l] is defined to be an index such that A[i] =
i. Given a sorted array of distinct integers, write a method to find a magic index, if
one exists, in array A.
FOLLOW UP
What if the values are not distinct?

Note: need to resolve this problem:
- You can either adjust both or omit the descending case
*/

public class RecursionAndDynamicProgramming93 {
	public static int findMagicIndex(int[] array){
		if (array[0]==0){
			return 0;
		}
		if (array.length <= 1){
			return -1;
		}
		//considering negative int
		//Assume array is ascending
		int i = 0;
		while (array[i] < i && i < array.length){
			i++;
		}
		if (i==array.length){
			return -1;
		} else {
			return findIndexAscending(i, array);
		}
	}

	public static int findIndexAscending(int index, int[] array){
		if (index > array.length - 1) return -1;

		if (array[index] == index){
			return index;
		} else {
			return findIndexAscending(array[index], array);
		}
	}

	public static void main(String[] args){
		int[] array2 = {-4, -3, -2, 0, 2, 5, 6, 7, 8, 9};
		System.out.println(findMagicIndex(array2));
	}
}