package leet.code.easy;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = " a ";
		System.out.println(getLengOfLastWord(test));
	}
	
	public static int getLengOfLastWord(String str){
		if(str.trim().length() == 0){
			return 0;
		}
		
		String pureStr = str.trim();
		int lastSpaceIndex = pureStr.lastIndexOf(" ");
		
		return pureStr.substring(lastSpaceIndex+1).length();
	}

}
