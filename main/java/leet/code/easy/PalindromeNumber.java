package leet.code.easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1234321));
	}
	
    public static boolean isPalindrome(int x) {
    	
    	if(x < 0) {
    		return false;
    	}
        
    	int initx = x;
    	int reverse = 0;
    	
    	while(x != 0){
    		reverse = reverse*10 + x%10;
    		x = x/10;
    	}
    	
    	System.out.println(reverse);
    	if(initx == reverse){
    		return true;
    	}
    	
    	return false;
    	
    }
}
