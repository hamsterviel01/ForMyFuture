public class WorksApplicationsExcercise9 {
	public static int gcd(int a, int b){
		if (b == 0) return a;
		return gcd(b, a%b);
	}

	public static String[] returnSortedIrreducibleFraction(String[] fracs){
		int[] numerator = new int[fracs.length];
		int[] denumerator = new int[fracs.length];
		double[] value = new double[fracs.length];
		int[] order = new int[fracs.length];
		String[] sortedFraction = new String[fracs.length];

		for (int i=0; i<order.length; i++){
			order[i] = i;
		}

		for (int i=0; i<fracs.length; i++){
			String temp[] = fracs[i].split("/");
			numerator[i] = Integer.valueOf(temp[0]);
			denumerator[i] = Integer.valueOf(temp[1]);
			value[i] = (double)numerator[i]/(double)denumerator[i];
			int gcd = gcd(numerator[i], denumerator[i]);
			numerator[i] = numerator[i]/gcd;
			denumerator[i] = denumerator[i]/gcd;
		}
		heapSort(value, order);

		for (int i=0; i<sortedFraction.length; i++){
			int index = order[i];
			sortedFraction[i] = numerator[index] + "/" + denumerator[index];
		}

		return sortedFraction;
	}

	public static void heapSort(double[] input, int[] order){
		for (int i=0; i<input.length-1; i++){
			heapify(input, i, order);
		}
	}

	public static void heapify(double[] input, int n, int[] order){
		for (int i=(input.length+n)/2 - 1; i>=n; i--){
			swap(input, i, n, order);
		}
	}

	public static void swap(double[] input, int i, int n, int[] order){
		if (input[i] < input[2*i+1-n]){
			double temp = input[i];
			input[i] = input[2*i+1-n];
			input[2*i+1-n] = temp;
			int temp2 = order[i];
			order[i] = order[2*i+1-n];
			order[2*i+1-n] = temp2;
		}
		if (2*i+2-n < input.length){
			if (input[i] < input[2*i+2-n]){
				double temp = input[i];
				input[i] = input[2*i+2-n];
				input[2*i+2-n] = temp;
				int temp2 = order[i];
				order[i] = order[2*i+2-n];
				order[2*i+2-n] = temp2;
			}
		}
	}

	public static void printArray(Object[] input){
		for (int i=0; i<input.length; i++){
			System.out.print(input[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		String[] fracs = new String[]{"1/2", "13/6", "15/20", "7/3", "13/28", "63/36", "21/32"};
		printArray(returnSortedIrreducibleFraction(fracs));
	}
}