import java.io.*;

public class ArrayAndString15 {

	//Make no modification to current String
	//Time complexity O(n)
	public static String replaceSpace1(String str) {
		StringBuilder strBuilder = new StringBuilder();
		int length = str.length();

		if (length == 0) return null;

		for (int i=0; i<length; i++){
			char temp = str.charAt(i);
			if (temp != ' '){
				strBuilder.append(String.valueOf(temp));
			} else {
				strBuilder.append("%20");
			}
		}
		return strBuilder.toString();
	}

	public static void main(String[] args){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String str = in.readLine();
			System.out.println(replaceSpace1(str));
		} catch (IOException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}