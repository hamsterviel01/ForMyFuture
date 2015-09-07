public class WorksApplicationsExcercise8 {
	public static void segerateZeroAndOne(int[] arr){
		int start = 0;
		int end = arr.length-1;
		while (start < end){
			while (start < arr.length && arr[start] == 0){
				start++;
			}
			if (start == arr.length){
				printArray(arr);
				return;
			} 

			while (end > -1 && arr[end] == 1){
				end--;
			}
			if (end == -1){
				printArray(arr);
				return;
			}

			if (start > end){
				printArray(arr);
				return;
			}

			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		printArray(arr);
	}

	public static void printArray(int[] arr){
		for (int i=0; i<arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	public static void main(String[] args){
		//all 0s
		int[] arr1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		//all 1s
		int[] arr2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		//random & other weird cases
		int[] arr3 = new int[]{0, 0, 0, 0, 0, 1, 1, 1};

		segerateZeroAndOne(arr3);
	}
}