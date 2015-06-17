import java.io.*;
import java.util.*;

public class ArrayAndString16 {
    public static int[][] rotateNintyDegreeComponent(int[][] image, int start, int end){
        int length = image.length;
        int n = end - start - 1;
        for (int i=0; i<n; i++){
            int temp1 = image[start + i][start];
            int temp2 = image[end][i + start];
            int temp3 = image[end-i][end];
            int temp4 = image[start][end-i];
            
            image[start + i][start] = temp2;
            image[end][i + start] = temp3;
            image[end-i][end] = temp4;
            image[start][end-i] = temp1;
        }
        // System.out.println("Matrix at start = " + start);
        // printMatrix(image);
        return image;
    }
    
    public static int[][] rotateNintyDegree(int[][] image){
        int start = 0;
        int end = image.length - 1;
        while (end - start > 0){
            image = rotateNintyDegreeComponent(image, start, end);
            start++;
            end--;
        }
        return image;
    }

    public static void printMatrix(int[][] image){
        int n = image.length-1;
        int count = 0;
        System.out.println("-------------------------------");
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                Formatter f = new Formatter(System.out);
                f.format("%2d| ", image[i][j]);
                count ++;
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------------");
    }

    public static void fillMatrixWithRandomValue(int[][] image){
        int n = image.length - 1;
        Random randomGenerator = new Random();
        for (int i=0; i<=n; i++){
            for (int j=0; j<=n; j++){
                image[i][j] = randomGenerator.nextInt(100);
            }
        }
        
    }
    
    public static void main(String[] args){
        int[][] image = new int[8][8];
        fillMatrixWithRandomValue(image);
        printMatrix(image);

        image = rotateNintyDegree(image);
        printMatrix(image);
       
    }
}