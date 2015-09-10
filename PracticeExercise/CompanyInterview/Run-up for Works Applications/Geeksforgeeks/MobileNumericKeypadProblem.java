import java.util.*;

public class MobileNumericKeypadProblem {
	public static void numericKeyboard(int n, int index, int digit, String prevNumber, HashSet<String> list){
		if (digit > 9 || digit < 1){
			return;
		}
		//Index start with 0 when n is no of Digits --> start with 1
		if (index == n){
			list.add(prevNumber);
		} else {
			StringBuilder currentNumberSb = new StringBuilder();
			currentNumberSb.append(prevNumber);
			currentNumberSb.append(String.valueOf(digit));
			String currentNumber = currentNumberSb.toString();
			numericKeyboard(n, index+1, digit+3, currentNumber, list);
			numericKeyboard(n, index+1, digit-3, currentNumber, list);
			if (digit%3 == 0){
				numericKeyboard(n, index+1, digit-1, currentNumber, list);
			} else if (digit%3 == 1){
				numericKeyboard(n, index+1, digit+1, currentNumber, list);
			} else {
				numericKeyboard(n, index+1, digit+1, currentNumber, list);
				numericKeyboard(n, index+1, digit-1, currentNumber, list);
			}
		}
	}
	
	public static void numericKeyboard(int n){
		HashSet<String> list = new HashSet<String>();
		for (int i=1; i<=9; i++){
			numericKeyboard(n, 0, i, "", list);
		}
		for (String str: list){
			System.out.println(str);
		}
		System.out.println("List size: " + list.size());
	}
	public static void main(String[] args){
		numericKeyboard(2);
	}
}