package algorithm.Math;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n){
		if (n == 1) return "1";
		String s = countAndSay(n-1);

		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i=0; i<s.length(); i++) {
			char say = s.charAt(i);
			if (i == s.length()-1) {
				sb.append(count).append(say);
				break;
			}
			if (say == s.charAt(i+1)) {
				count++;
				continue;
			}
			sb.append(count).append(say);
			count = 1;
		}
		return sb.toString();
	}
}
