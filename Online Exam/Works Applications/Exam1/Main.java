import java.io.*;

/**
Optimal structure:
maxPoint(x, y) = matrix[x][y] + maxValue(maxPoint(x, y+1), maxPoint(x-1, y, exclude(listOfVisistedPoint)), maxPoint(x+1, y, exclude(listOfVisistedPoint)));
*/

public class Main {
//	public static void printCache(long[][] cache){
//		System.out.print("///////////////////////////");
//		for (int i=0; i<cache.length; i++){
//			for (int j=0; j<cache[0].length; j++){
//				System.out.print(cache[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
	
	public static long findMaximumPoint(int[][] matrixPoint){
		int maxX = matrixPoint.length-1;
		long[][] cache = new long[matrixPoint.length][matrixPoint[0].length];
		long[][] cacheUp = new long[matrixPoint.length][matrixPoint[0].length];
		long[][] cacheDown = new long[matrixPoint.length][matrixPoint[0].length];
		for (int i=0; i<cache.length; i++){
			for (int j=0; j<cache[0].length; j++){
				cache[i][j] = -2;
				cacheUp[i][j] = -2;
				cacheDown[i][j] = -2;
			}	
		}

		long max = -1;
		for (int i=0; i<matrixPoint.length; i++){
			long temp = findMaximumPoint(matrixPoint, i, 0, cache, cacheUp, cacheDown);
			if (temp > max){
				max = temp;
			}
		}

//		printCache(cache);
//		printCache(cacheUp);
//		printCache(cacheDown);
		
		//Usual algorithm will never reach these point, but the snake can still access it through teleport, so we still need to consider it
		//Dont need to care if value of this point is -1, it will be checked at findMaximumPoint func
		//Value of matrixPoint at y = 0 has been taken care of, now we only need to care about y = 1 and onward
		for (int j=1; j<matrixPoint[0].length; j++){
			if (cacheUp[0][j] == -2 && cache[0][j] == -2 && (cacheDown[maxX][j] != -2 || cache[maxX][j] != -2) && matrixPoint[maxX][j] != -1){
				long temp = findMaximumPoint(matrixPoint, 0, j, cache, cacheUp, cacheDown);
				if (temp > max){
					max = temp;
				}
			}
			if (cacheDown[maxX][j] == -2 && cache[maxX][j] == -2 && (cacheUp[0][j] != -2 || cache[0][j] != -2) && matrixPoint[0][j] != -1){
				long temp = findMaximumPoint(matrixPoint, maxX, j, cache, cacheUp, cacheDown);
				if (temp > max){
					max = temp;
				}
			}		
		}
//		System.out.println("----------------------------------");
//		printCache(cache);
//		printCache(cacheUp);
//		printCache(cacheDown);
		return max;
	}

	//Need to check if number of input match m and n
	public static long findMaximumPoint(int[][] matrixPoint, int x, int y, long[][] cache, long[][] cacheUp, long[][] cacheDown){
		//if the snake has gone outside the matrix, if return -1 here, the whole cache will become -1.
		if (y > matrixPoint[0].length-1){
			return 0;
		}
		//if this position has been calculated
		if (cache[x][y] != -2) return cache[x][y];
		//if this position is blocked
		if (matrixPoint[x][y] == -1){
			cacheUp[x][y] = -1;
			cache[x][y] = -1;
			cacheDown[x][y] = -1;
			return cache[x][y];
		}	

		long up = findMaximumPointUp(matrixPoint, x-1, y, cache, cacheUp, cacheDown);
		long down = findMaximumPointDown(matrixPoint, x+1, y, cache, cacheUp, cacheDown);
		long right = findMaximumPoint(matrixPoint, x, y+1, cache, cacheUp, cacheDown);
		long max = Math.max(Math.max(up, down), right);
		if (max == -1){
			cache[x][y] = -1;		
		} else {
			cache[x][y] = max + matrixPoint[x][y];
		}
		return cache[x][y];
	}

	public static long findMaximumPointUp(int[][] matrixPoint, int x, int y, long[][] cache, long[][] cacheUp, long[][] cacheDown){
		//if the snake has gone outside the matrix
		if (y > matrixPoint[0].length-1){
			return 0;
		}
		if (x < 0){
			return -1;
		}
		//if this position has been calculated
		if (cacheUp[x][y] != -2) return cacheUp[x][y];
		//if this position is blocked
		if (matrixPoint[x][y] == -1){
			cacheUp[x][y] = -1;
			cache[x][y] = -1;
			cacheDown[x][y] = -1;
			return cache[x][y];
		}

		long right = findMaximumPoint(matrixPoint, x, y+1, cache, cacheUp, cacheDown);
		long up = findMaximumPointUp(matrixPoint, x-1, y, cache, cacheUp, cacheDown);
		long max = Math.max(right, up);
		if (max == -1){
			cacheUp[x][y] = -1;
		} else {
			cacheUp[x][y] = matrixPoint[x][y] + max;
		}
		return cacheUp[x][y];
	}

	public static long findMaximumPointDown(int[][] matrixPoint, int x, int y, long[][] cache, long[][] cacheUp, long[][] cacheDown){
		//if the snake has gone outside the matrix
		if (y > matrixPoint[0].length-1){
			return 0;
		}
		int maxX = matrixPoint.length-1;
		if (x > maxX){
			return -1;
		}
		//if this position has been calculated
		if (cacheDown[x][y] != -2) return cacheDown[x][y];
		if (matrixPoint[x][y] == -1){
			cacheUp[x][y] = -1;
			cache[x][y] = -1;
			cacheDown[x][y] = -1;
			return cache[x][y];
		}
		
		long right = findMaximumPoint(matrixPoint, x, y+1, cache, cacheUp, cacheDown);
		long down = findMaximumPointDown(matrixPoint, x+1, y, cache, cacheUp, cacheDown);
		long max = Math.max(right, down);
		if (max == -1){
			cacheDown[x][y] = -1;
		} else {
			cacheDown[x][y] = matrixPoint[x][y] + max;
		}
		return cacheDown[x][y];
	}

	public static void main(String[] args) {
		// TODO: Implement your program
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String[] line = rd.readLine().split(" ");
			int numberOfInputLine = Integer.valueOf(line[0]);
			int[][] matrix = new int[Integer.valueOf(line[0])][Integer.valueOf(line[1])];
			int i = 0;
			String inputLine;

			while (i < numberOfInputLine && (inputLine = rd.readLine()) != null && inputLine.length() > 0){
				String[] input = inputLine.split(" ");
				for(int j=0; j<input.length; j++){
					matrix[i][j] = Integer.valueOf(input[j]);
				}
				i++;
			}
			System.out.println(findMaximumPoint(matrix));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				rd.close();
			} catch (IOException e){
				e.printStackTrace();
			}	
		}
	}
}