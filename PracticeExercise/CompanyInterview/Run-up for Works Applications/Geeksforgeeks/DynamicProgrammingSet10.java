public class DynamicProgrammingSet10 {
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
		int[] val = new    int[]{0, 9, 8, 7, 4, 5, 3, 11};
		int[] weight = new int[]{0, 4, 2, 3, 2, 2, 5, 4 };
		int remainWeight = 17;

		System.out.println(getMaxValueDynamic(val, weight, remainWeight));
	}
}