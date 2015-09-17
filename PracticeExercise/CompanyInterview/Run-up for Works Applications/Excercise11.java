import java.util.HashSet;


public class Excercise11 {
	public static int gcm(int a, int b){
		if (b == 0) return a;
		return gcm(b, a%b);
	}
	
	public static HashSet<String> returnAllFracs(int m, int n){
		if (m == 0 || m > n) return null;
		HashSet<String> result = new HashSet<String>();
		for (int i=m; i<=n; i++){
			for (int j=1; j<i; j++){
				int gcm = gcm(i, j);
				int num = i/gcm;
				int denum = j/gcm;
				if (num%denum == 0){
					result.add(String.valueOf(num/denum));
				} else {
					result.add(String.valueOf(num) + "/" + String.valueOf(denum));
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(returnAllFracs(3, 6));
		System.out.println(returnAllFracs(6, 6));
		System.out.println(returnAllFracs(0, 6));
		System.out.println(returnAllFracs(3, 2));
		System.out.println(returnAllFracs(300, 600));
	}

}
