/**
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

public class DynamicProgrammingSet13 {
	public static int maxObtainValue(int[] price, int n){
		RodUnit[] pricePerInch = new RodUnit[price.length];
		for (int i=0; i<price.length; i++){
			RodUnit temp = new RodUnit(i+1, (double)price[i]/(i+1), price[i]);
			pricePerInch[i] = temp;
		}	
		heapSort(pricePerInch, 0);
		for (int i=0; i<pricePerInch.length; i++){
			System.out.print(" " + pricePerInch[i].pricePerInch);
		}
		
		return maxObtainValue(pricePerInch, n, 0);
	}
	
	public static int maxObtainValue(RodUnit[] pricePerInch, int n, int currentIndex){
		if (currentIndex == pricePerInch.length - 1){
			return pricePerInch[pricePerInch.length-1].price;
		}
		if (pricePerInch[currentIndex].length < n){
			return pricePerInch[currentIndex].price + maxObtainValue(pricePerInch, n-pricePerInch[currentIndex].length, currentIndex);
		} else {
			while (pricePerInch[currentIndex].length > n){
				currentIndex++;
				System.out.println("currentIndex=" + currentIndex + " n=" + n + "pricePerInch=" + pricePerInch[currentIndex].pricePerInch);
			}
			return pricePerInch[currentIndex].price + maxObtainValue(pricePerInch, n-pricePerInch[currentIndex].length, currentIndex);
		}
	}
	
	public static void heapSort(RodUnit[] arr, int start){
		if (start == arr.length-1) return;
		int mid = (arr.length - start - 1)/2;
		for (int i=start; i<=mid; i++){
			heapify(arr, i);
		}
		heapSort(arr, start+1);
	}
	
	public static void heapify(RodUnit[] arr, int i){
		if (arr[i].pricePerInch < arr[2*i + 1].pricePerInch){
			RodUnit temp = arr[i];
			arr[i] = arr[2*i + 1];
			arr[2*i + 1] = temp;
		}
		
		if (2*i + 2 < arr.length){
			if (arr[i].pricePerInch < arr[2*i + 2].pricePerInch){
				RodUnit temp = arr[i];
				arr[i] = arr[2*i + 2];
				arr[2*i + 2] = temp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(maxObtainValue(price, 8));
	}

}

class RodUnit {
	int length;
	int price;
	double pricePerInch;
	RodUnit(int length, double pricePerInch, int price) {
		this.length = length;
		this.pricePerInch = pricePerInch;
		this.price = price;
	}
}
