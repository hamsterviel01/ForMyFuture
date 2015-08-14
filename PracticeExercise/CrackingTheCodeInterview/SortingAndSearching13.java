/**
Lesson learnt:
- Don't be a lazy ass, you should implement solution to carter all the cases you knew can wreck your program, assuming that user enter valid input.
*/

public class SortingAndSearching13 {
	//Algorithm: 
	public static int findElementIndex(int[] array, int value, int start, int end){
		int mid = (start + end)/2;
		if (value == array[mid]){
			return mid;
		}
		if (value == array[start]){
			return start;
		}
		if (value == array[end]){
			return end;
		}
		if (start<end){
			if (array[mid] < array[start]){
				if (value > array[start] || value < array[mid]){
					return findElementIndex(array, value, start+1, mid-1);
				} else {
					return findElementIndex(array, value, mid+1, end-1);
				}
			} else if (array[mid] > array[start]){
				if (value < array[mid] && value > array[end]){
					return findElementIndex(array, value, start+1, mid-1);
				} else {
					return findElementIndex(array, value, mid+1, end-1);
				}
			} else {
				while (array[mid] == array[start] && start < end){
					start++;
				}
				if (start == end) return -1;
				return findElementIndex(array, value, start, end-1);
			}
		}
		return -1;
	}

	public static int findElementIndex(int[] array, int value){
		if (array.length == 0) return 0;
		return findElementIndex(array, value, 0, array.length - 1);
	}

	public static void main(String[] args){
		int[] array1 = new int[]{3, 4, 6, 7, 8, 9, 1, 2};
		int[] array2 = new int[]{16, 16, 16, 17, 18, 19, 16, 16, 16, 16, 1, 2, 3, 4, 5, 6, 7};

		System.out.println(findElementIndex(array1, 5));
		System.out.println(findElementIndex(array2, 18));
	}
}