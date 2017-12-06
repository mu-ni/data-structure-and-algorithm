package leet.code.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
		//System.out.println(reverse(-123));
	}

	public static int reverse(int x) {
		int rst = 0;
		
		while(x != 0){
			
			if(rst !=0 && Integer.MAX_VALUE/rst <10 && Integer.MAX_VALUE/rst > -10){
				return 0;
			}
			
			rst = rst*10 + x%10;
			x = x/10;
		}
		
		return rst;
	}
//	public static int reverse(int x) {
//		System.out.println(Integer.MAX_VALUE);
//		if (x > Integer.MAX_VALUE) {
//			return 0;
//		}
//
//		String ipt = String.valueOf(x);
//		String rst = "";
//		for (int i = 0; i < ipt.length(); i++) {
//
//			if (ipt.substring(0, 1).equals("-")) {
//				ipt = ipt.substring(1);
//				rst = "-";
//			}
//
//			rst += ipt.substring(ipt.length() - i - 1, ipt.length() - i);
//
//		}
//
//		return Integer.valueOf(rst);
//	}

//	public static int reverse(int x) {
//		int rev = 0;
//		while (x != 0) {
//			if (rev != 0 && Integer.MAX_VALUE / rev < 10 && Integer.MAX_VALUE / rev > -10){
//				System.out.println(rev*10);
//				return 0;
//			}
//			rev = rev * 10 + x % 10;
//			x = x / 10;
//		}
//		return rev;
//	}
}
