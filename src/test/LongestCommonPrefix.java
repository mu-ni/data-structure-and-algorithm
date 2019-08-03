package test;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(input));
	}
	
    public static String longestCommonPrefix(String[] strs) {
    	
    	if (strs.length == 0){
    		return "";
    	}
        
    	String prefix = strs[0];
    	for(int i=0;i< strs.length ; i++){
    		while(strs[i].indexOf(prefix) != 0){
    			prefix = prefix.substring(0, prefix.length()-1);//{'a','b'}
    		}
    	}
    	
    	return prefix;
    }
}
