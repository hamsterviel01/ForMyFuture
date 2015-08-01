public class SortingAndSearching16 {
	public static int getColumn(int value, int[] arrayZero, int start, int end){
		if (start == end) return start;

		int mid = (start+end)/2;

		if (arrayZero[mid]==value) return mid;
		if (arrayZero[start]==value) return start;
		if (arrayZero[end]==value) return end;

		if (arrayZero[mid]<value){
			if (arrayZero[mid+1]>value){
				return mid;
			} else if (arrayZero[mid+1]==value){
				return mid+1;
			} else {
				return getColumn(value, arrayZero, mid+1, end-1);
			}
		} else {
			if (arrayZero[mid-1]<=value){
				return mid-1;
			} else {
				return getColumn(value, arrayZero, start+1, mid-1);
			}
		} 

	}

	public static int getIndexFromColumn(int column, int[][] array){
		return 1;
	}

	public static void main(String[] args){

	}
}