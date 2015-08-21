public class DynamicProgrammingSet10 {
	//Naive solution
	public static int getMaxValue(int[] val, int[] weight, int remainWeight){
		if (remainWeight < 0) return Integer.MIN_VALUE;
		if (remainWeight == 0) return 0;

		int max = 0;
		for (int i=1; i<val.length; i++){
			int temp = val[i] + getMaxValue(val, weight, remainWeight - weight[i]);
			if (temp > max){
				max = temp;
			}
		}

		return max;
	}

	public static void main(String[] args){
		int[] val = new int[]{0, 9, 8, 7, 4, 5, 3, 11};
		int[] weight = new int[]{0, 4, 2, 3, 2, 2, 5, 4};
		int remainWeight = 9;

		System.out.println(getMaxValue(val, weight, remainWeight));
	}
}