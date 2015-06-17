//Time complexity O(m*n);
//Use 2 extra array to store boolean value of which row to update

import java.io.*;
import java.util.*;

public class ArrayAndString17 {
	public static void setRowAndColumnToZero(int[][] matrix){
		//
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[] rowSetToZero = new boolean[n];
		boolean[] columnSetToZero = new boolean[m];

		//loop through matrix to find 0 and record down co-ordinate to update
		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				if ((matrix[i][j] == 0 && !rowSetToZero[i]) || (matrix[i][j] == 0 && !columnSetToZero[j])){
					rowSetToZero[i] = true;
					columnSetToZero[j] = true;
				}
			}
		}

		//Set all qualify rows to 0
		for (int i=0; i<n; i++){
			if (rowSetToZero[i]){
				for (int j=0; j<m; j++){
					matrix[i][j] = 0;
				}
			}
		}

		//Set all qualify columns to 0
		for (int j=0; j<m; j++){
			if (columnSetToZero[j]){
				for (int i=0; i<n; i++){
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void randomizeMatrixWithZeros(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;

		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				Random random = new Random();
				int randomInt = random.nextInt(100);
				if (randomInt%5 == 0){
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = randomInt;
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;

		System.out.println("---------------------------");
		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				Formatter formater = new Formatter(System.out);
				formater.format("%2d|", matrix[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("---------------------------");
	}

	public static void main(String[] args){
		int[][] matrix = new int[5][7];
		randomizeMatrixWithZeros(matrix);
		printMatrix(matrix);
		setRowAndColumnToZero(matrix);
		printMatrix(matrix);
	}
}