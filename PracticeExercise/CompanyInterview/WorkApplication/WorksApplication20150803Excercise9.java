public class WorksApplication20150803Excercise9 {
	public static void getSortedFractionSeq(String[] input) {
		double[] inputDouble = new double[input.length];
		int[] inputSort = new int[input.length];

		for (int i=0; i<input.length; i++){
			input[i] = reduceToIrreducibleForm(input[i]);
			String[] fracs = input[i].split("/");
			inputDouble[i] = Double.valueOf(fracs[0])/Double.valueOf(fracs[1]);
			inputSort[i] = i;
		}

		heapsortFractionSeq(inputDouble, inputSort, input.length-1);
		for (int i=0; i<input.length; i++){
			System.out.print(" " + input[inputSort[i]]);
		}
	}

	public static void heapsortFractionSeq(double[] input, int[] inputSort, int end){
		if (end > 0){
			headify(input, inputSort, end);
			//swap input[end] with input[0]
			int temp = inputSort[0];
			inputSort[0] = inputSort[end];
			inputSort[end] = temp;
			heapsortFractionSeq(input, inputSort, end-1);
		}
	}

	public static void headify(double[] input, int[] inputSort, int end){
		int mid = (end-1)/2;

		for (int i=mid; i>=0; i--){
			if (input[inputSort[i]] < input[inputSort[2*i + 1]]){
				int temp1 = inputSort[i];
				inputSort[i] = inputSort[2*i + 1];
				inputSort[2*i + 1] = temp1;
			}

			if (end >= 2*i+2){
				if (input[inputSort[i]] < input[inputSort[2*i+2]]){
					int temp1 = inputSort[i];
					inputSort[i] = inputSort[2*i + 2];
					inputSort[2*i + 2] = temp1;
				}
			}
		}
	}

	public static String reduceToIrreducibleForm (String frac){
		String[] fracs = frac.split("/");
		int numerator = Integer.valueOf(fracs[0]);
		int denumerator = Integer.valueOf(fracs[1]);
		int tempNum = numerator;
		int tempDenum = tempNum;
		int gcd = 0;

		if (numerator > denumerator){
			while (tempDenum != 0){
				int temp = tempDenum;
				tempDenum = tempNum%tempDenum;
				tempNum= temp;
			}
			gcd = tempNum;
		} else {
			while (tempNum != 0){
				int temp = tempNum;
				tempNum = tempDenum%tempNum;
				tempDenum = temp;
			}
			gcd = tempDenum;
		}
		
		return String.valueOf(numerator/gcd) + "/" + String.valueOf(denumerator/gcd);
	}

	public static void main(String[] args){
		String[] input = new String[]{"13/17", "18/12", "120/72", "5/7", "100/150", "200/525"};
		getSortedFractionSeq(input);
	}
}