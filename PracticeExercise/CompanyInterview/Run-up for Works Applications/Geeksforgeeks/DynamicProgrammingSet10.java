public class DynamicProgrammingSet10 {
	//Dynamic Solution
	// public static int getMaxValueDynamic(int[] val, int[] weight, int remainWeight, int[] maxValueCache){
	// 	if (remainWeight < 0) return Integer.MIN_VALUE;
	// 	if (remainWeight == 0) return 0;
	// 	if (maxValueCache[remainWeight] != 0) return maxValueCache[remainWeight];

	// 	int max=0;
	// 	for (int i=1; i<val.length; i++){
	// 		int temp = val[i] + getMaxValueDynamic(val, weight, remainWeight - weight[i], maxValueCache);
	// 		if (temp > max){
	// 			max = temp;
	// 		}
	// 	}

	// 	maxValueCache[remainWeight] = max;
	// 	return maxValueCache[remainWeight];
	// }

	// public static int getMaxValueDynamic(int[] val, int[] weight, int remainWeight){
	// 	int[] maxValueCache = new int[remainWeight+1];
	// 	return getMaxValueDynamic(val, weight, remainWeight, maxValueCache);
	// }

	public static int getMaxValueDynamic(int[] val, int[] weight, int n){
		int[] results = new int[n+1];

		//f(v, w, n) = f(v, w, n-w[0]) + v[0];
		for (int i=0; i<=n; i++){
			int max = 0;
			for (int j=0; j<val.length; j++){
				if (i >= weight[j] && max < results[i-weight[j]] + val[j]){
					max = results[i-weight[j]] + val[j];
 				}
			}
			results[i] = max;
		}

		return results[n];
	}

	public static void main(String[] args){
		int[] val = new    int[]{0, 9, 8, 7, 4, 5, 3, 11};
		int[] weight = new int[]{0, 4, 2, 3, 2, 2, 5, 4 };
		int remainWeight = 900000;

		System.out.println(getMaxValueDynamic(val, weight, remainWeight));
	}
}