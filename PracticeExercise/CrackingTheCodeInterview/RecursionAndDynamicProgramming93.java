/**
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
		if (isAscending(array)){
			//considering negative int
			int i = 0;
			while (array[i] < i && i < array.length){
				i++;
			}
			if (i==array.length){
				return -1;
			} else {
				return findIndexAscending(i, array);
			}
		} else {
			return findIndexDescending(0, array.length - 1, array);
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

	//correct for negative int also
	public static int findIndexDescending(int lowerBound, int higherBound, int[] array){
		//stopping conditions
		if (lowerBound == higherBound) return -1;
		int mid = (lowerBound + higherBound)/2;

		if (array[mid] == mid){
			return mid;
		} else if (array[mid] > mid){
			return findIndexDescending(mid + 1, higherBound, array);
		} else {
			return findIndexDescending(lowerBound, mid - 1, array);
		}
	}

	public static boolean isAscending(int[] array){
		int i = 0;
		while (array[i] == array[i+1] && i<array.length - 1){
			i++;
		}
		return array[i] < array[i+1];
	}

	public static void main(String[] args){
		int[] array1 = {10, 9, 7, 5, 4, 3, 2, -1, -2};
		int[] array2 = {-4, -3, -2, 0, 2, 5, 6, 7, 8, 9};
		System.out.println(findMagicIndex(array1));
		System.out.println(findMagicIndex(array2));
	}
}