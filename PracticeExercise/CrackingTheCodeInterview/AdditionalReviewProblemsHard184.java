public class AdditionalReviewProblemsHard184 {
	public static int getNumberOfDigits(int n){
		int i = 0;
		int temp = n;
		
		while(temp > 0){
			temp = temp/10;
			i++;
		}
		return i;
	}

	public static int getNumberOfTwos(int n, int digits, int decimalPoint){
		if (n < 2) return 0;
		if (n >=2 && n <=9) return 1;

		if (n < 2*decimalPoint){
			return decimalPoint - (int)Math.pow(9, digits-1) 
			+ getNumberOfTwos(n%decimalPoint, digits-1, decimalPoint/10);
		}

		if (n >= 2*decimalPoint && n<3*decimalPoint){
			return 2*getNumberOfTwos(decimalPoint, digits, decimalPoint) 
			+ n-2*decimalPoint + 1  
			+ getNumberOfTwos(n%decimalPoint, digits-1, decimalPoint/10);
		}

		return getNumberOfTwos(decimalPoint*3-1, digits, decimalPoint) 
		+ (n/decimalPoint - 3)*getNumberOfTwos(decimalPoint, digits, decimalPoint) 
		+ getNumberOfTwos(n%decimalPoint, digits-1, decimalPoint/10);
	}

	public static int getNumber(int n){
		int digits = getNumberOfDigits(n);
		int decimalPoint = (int)Math.pow(10, digits-1);

		if (n == decimalPoint) {
			return decimalPoint - (int)Math.pow(9, digits-1) + 1;
		}

		return getNumberOfTwos(n, digits, decimalPoint);
	}
	
	public static void main(String[] args){
		//The case where n = decimal point didn't display correctly, but other case was just fine
		System.out.println(getNumber(100));
		System.out.println(getNumber(52));
		System.out.println(getNumber(24));
		System.out.println(getNumber(1052));
	}
}