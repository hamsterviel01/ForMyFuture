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

	//Dynamic Solution
	public static int getMaxValueDynamic(int[] val, int[] weight, int remainWeight, int[] maxValueCache){
		if (remainWeight < 0) return Integer.MIN_VALUE;
		if (remainWeight == 0) return 0;
		if (maxValueCache[remainWeight] != 0) return maxValueCache[remainWeight];

		int max=0;
		for (int i=1; i<val.length; i++){
			int temp = val[i] + getMaxValueDynamic(val, weight, remainWeight - weight[i], maxValueCache);
			if (temp > max){
				max = temp;
			}
		}

		maxValueCache[remainWeight] = max;
		return maxValueCache[remainWeight];
	}

	public static int getMaxValueDynamic(int[] val, int[] weight, int remainWeight){
		int[] maxValueCache = new int[remainWeight+1];
		return getMaxValueDynamic(val, weight, remainWeight, maxValueCache);
	}

	public static void main(String[] args){
		int[] val = new    int[]{0, 9, 8, 7, 4, 5, 3, 11, 9, 8, 7, 4, 5, 3, 11, 9, 8, 7, 4, 5, 3, 11, 9, 8, 7, 4, 5, 3, 11};
		int[] weight = new int[]{0, 4, 2, 3, 2, 2, 5, 4 , 9, 8, 7, 4, 5, 3, 11, 4, 2, 3, 2, 2, 5, 4 , 9, 8, 7, 4, 5, 3, 11};
		int remainWeight = 900;

		System.out.println(getMaxValue(val, weight, remainWeight));
	}
}