import java.io.*;

public class ArrayAndString13 {
	public static void removeDuplicateCharacter(char[] str){
		//initial check for return null condition
		if (str == null) return;
		int length = str.length;
		if (length < 2) return;

		//if char array has at least 2 character.
		int tail = 1;

		//in case str = "aa"
		if (str[0] == str[1] && length == 2){
			str[1] = 0;
			return;
		} else {
			//Check duplication against the first 2 character
			if (str[0] == str[1]){
				str[1] = 0;
			}

			//loop through char array, excluding the first 2 char, i = tail + 1
			for (int i=2; i<length; i++){
				//loop through array char [0 -> tail]
				int j;
				for (j=0; j<=tail; j++){
					//if duplicated character is found for str[i], break, j < tail
					if (str[i] == str[j]) break;
				}
				//if duplicated character for str[i] is not found, j=tail+1 -> set tail=i/tail=tail+1 to accept new char
				//else, set tail=i and set str[tail] to 0;
				if (j==(tail+1)){
					tail=i;
				} else {
					tail=i;
					str[tail] = 0;
				}
			}
		}
	}


	//To test code
	public static void main(String[] args) throws IOException{
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			String inputStr = rd.readLine();
			char[] str = inputStr.toCharArray();
			removeDuplicateCharacter(str);
			System.out.println(str);
		} catch (IOException e){
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

// test case:
// case 1: aa;
// case 2: a;
// case 3: 0;
// case 4: abcdefabcfh;
// case 5: aabb;