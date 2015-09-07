public class WorksApplicationsExcercise3 {
	public static String convertString(String str){
		if (str.length() == 0) return null;

		char temp = str.charAt(0);
		int count = 0;
		StringBuilder sb = new StringBuilder();

		//in java, string doesn't end with null char ('\0')
		for (int i=0; i<str.length(); i++){
			if (temp != str.charAt(i)){
				sb.append(temp);
				sb.append(String.valueOf(count));
				temp = str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		sb.append(temp);
		sb.append(String.valueOf(count));

		return sb.toString();
	}

	public static void main(String[] args){
		System.out.println(convertString("aaaabbbcc"));
	}
}