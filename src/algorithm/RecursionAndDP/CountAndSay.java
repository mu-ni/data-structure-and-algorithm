package algorithm.RecursionAndDP;

public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

	public static String countAndSay(int n){
		if (n == 1) return "1";
		String s = countAndSay(n-1);

		StringBuilder sb = new StringBuilder();
		int count = 1;
		char say = s.charAt(0);
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				count++;
				continue;
			}
			sb.append(count).append(say);
			count = 1;
			say = s.charAt(i);
		}
		sb.append(count).append(say);
		return sb.toString();
	}
}
