public class BinarySearch {
	public static int binarySearch(int[] sortedInput, int value, int start, int end){
		int mid = (start+end)/2;

		if (sortedInput[mid] == value) return mid;
		if (sortedInput[start] == value) return start;
		if (sortedInput[end] == value) return end;
		if (start >= end) return -1;

		if (value > sortedInput[mid]){
			return binarySearch(sortedInput, value, mid + 1, end -1);
		} else {
			return binarySearch(sortedInput, value, start + 1, mid - 1);
		}
	}

	public static int binarySearch(int[] sortedInput, int value){
		if (sortedInput.length == 0) return -1;
		if (value < 0) return -1;
		return binarySearch(sortedInput, value, 0, sortedInput.length - 1);
	}

	public static void main(String[] args){
		int[] sortedInput = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		System.out.println(binarySearch(sortedInput, 12));
	}
}