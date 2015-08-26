public class Main {
	//Need to check if number of input match m and n
	public static int findMaximumPoint(int[][] matrixPoint, int x, int y, int[][] cache){
		//if the snake has gone outside the matrix
		if (y > matrixPoint[0].length-1){
			return 0;
		}
		//if this position has been calculated
		if (cache[x][y] != -2) return cache[x][y];

		//if this position is blocked
		if (matrixPoint[x][y] == -1){
			cache[x][y] = -1;
			return cache[x][y];
		}

		//if the snake is at top or bottom
		//since -1 < vi < 99999 --> see if we can use Interger.MIN_VALUE
		if (x == 0) {

		} else if (x == matrixPoint.length-1){
			
		}

		//if the snake has reached right border
		if (y == matrixPoint[0].length){
			cache[x][y] = matrixPoint[x][y] + max(findMaximumPoint(matrixPoint, x-1, y, cache), findMaximumPoint(matrixPoint, x+1, y, cache));
			return cache[x][y];
		}

		int max = max(findMaximumPoint(matrixPoint, x-1, y, cache), findMaximumPoint(matrixPoint, x+1, y, cache), 
			findMaximumPoint(matrixPoint, x, y+1, cache));
		if (max == -1){
			cache[x][y] = -1;
			return cache[x][y];
		} else {
			else cache[x][y] = max + matrixPoint[x][y];
			return cache[x][y];
		}
	}

	public static int max(int... values){
		//equal to -1 because the smallest value in matrixPoint is -1
		int max = -1;
		for (int i: values){
			if (i > max){
				max = i;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO: Implement your program
		BufferReader rd = new BufferReader(new InputStreamReader(System.in));

		//Do I need to check if only 2 int was input in the first line???
		String[] line = rd.readLine();
		int[][] matrix = new int[Integer.valueOf(line[0])][Integer.valueOf(line[1])];

		while (line = rd.readLine() != null && line.length() > 0){
			String[] input = line.split(" ");
			for()
		}

	}
}