public class DynamicProgrammingSet6 {
	public static int minPathCost(int[][] cost, int m, int n, int x, int y, int[][] minPath){
		if ((x == m-1 && y == n-1) || (x == m-1 && y == n) || (x == m && y == n-1)){
			//We don't jump out of (m, n) do we??
			minPath[x][y] = cost[x][y];
			return minPath[x][y];
		}

		if (x > m || y > n){
			return Integer.MAX_VALUE;
		}

		if (minPath[x][y] != 0){
			return minPath[x][y];
		}
		
		minPath[x][y] = cost[x][y] + min(minPathCost(cost, m, n, x+1, y+1, minPath), 
			minPathCost(cost, m, n, x, y+1, minPath), 
			minPathCost(cost, m, n, x+1, y, minPath));
		return minPath[x][y];
	}

	public static int minPathCost(int[][] cost, int m, int n){
		int[][] minPath = new int[m+1][n+1];
		return minPathCost(cost, m, n, 0, 0, minPath);
	}

	//utility func
	public static int min(int... numbers){
		int min = Integer.MAX_VALUE;
		for (int each: numbers){
			min = Math.min(min, each);
		}
		return min;
	}

	public static void main(String[] args){
		int[][] cost = new int[][]{
			{1, 2, 4, 6, 3, 1, 2, 4, 6, 3},
			{3, 4, 5, 2, 1, 1, 2, 4, 6, 3},
			{1, 1, 2, 9, 1, 1, 1, 2, 9, 1},
			{8, 1, 7, 1, 2, 8, 1, 7, 1, 2},
			{1, 2, 4, 6, 3, 8, 1, 7, 1, 2},
			{3, 4, 5, 2, 8, 1, 7, 1, 2, 3},
			{1, 1, 2, 9, 8, 2, 1, 7, 1, 2},
			{8, 1, 7, 1, 2, 8, 1, 7, 1, 2}
		};

		System.out.println(minPathCost(cost, 7, 9));
	}
}