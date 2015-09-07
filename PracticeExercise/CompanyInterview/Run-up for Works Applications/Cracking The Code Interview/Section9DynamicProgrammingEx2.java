public class Section9DynamicProgrammingEx2 {
	//Follow up with off-limit points
	public static int countPossiblePaths(int x, int y, int[][] cache, int[][] map){
		if (x== -1) return 0;
		if (y== -1) return 0;
		if (x==0 && y==0) return 1;
		if (map[x][y] == -1){
			return 0;
		} 
		if (cache[x][y] != 0) return cache[x][y];

		cache[x][y] = countPossiblePaths(x-1, y, cache, map) + countPossiblePaths(x, y-1, cache, map);
		return cache[x][y];
	}

	public static int countPossiblePaths(int x, int y, int[][] map){
		int[][] cache = new int[x+1][y+1];
		return countPossiblePaths(x, y, cache, map);
	}

	public static void main(String[] args){
		int x = 2;
		int y = 3;
		int[][] map = new int[x+1][y+1];
		map[2][2] = -1;
		System.out.println(countPossiblePaths(2, 3, map));
	}
}