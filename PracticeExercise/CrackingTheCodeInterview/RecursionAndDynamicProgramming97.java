public class RecursionAndDynamicProgramming97 {
	public static void painFill(int x, int y, int[][] screen, int color, int originalColor){
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[1].length){
			return;
		}
		if (screen[x][y] == originalColor){
			screen[x][y] = color;
			painFill(x+1, y, screen, color, originalColor);
			painFill(x-1, y, screen, color, originalColor);
			painFill(x, y+1, screen, color, originalColor);
			painFill(x, y-1, screen, color, originalColor);
		}
	}

	public static void painFill(int x, int y, int[][] screen, int color){
		int originalColor = screen[x][y];
		if (originalColor == color){
			return;
		} else {
			painFill(x, y, screen, color, originalColor);
		}
	}

	public static void main(String[] args){
		int[][] screen = {
			{5, 2, 3, 2, 3, 1},
			{5, 1, 1, 1, 1, 4},
			{3, 1, 1, 1, 1, 3},
			{3, 1, 2, 1, 1, 2},
			{5, 1, 1, 2, 1, 2}
		};

		painFill(2, 2, screen, 6);

		for (int i=0; i<screen.length; i++){
			for (int j=0; j<screen[i].length; j++){
				System.out.print(" " + screen[i][j]);
			}
			System.out.println();
		}
	}
}