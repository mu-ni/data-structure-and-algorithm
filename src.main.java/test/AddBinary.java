package test;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addBinary("1010","1011"));
	}

	public static String addBinary(String a, String b){
		
		String maxLenStr = a.length() > b.length()?a:b;
		String minLenStr = a.length() > b.length()?b:a;
		
		String revMax = new StringBuilder().append(maxLenStr).reverse().toString();
		String revMin = new StringBuilder().append(minLenStr).reverse().toString();

		StringBuilder sb = new StringBuilder();
		int carry = 0;	
		
		
		for(int i=0;i<Math.max(a.length(), b.length());i++){
			
			if(i < Math.min(a.length(), b.length())){
				int sum = carry + Character.getNumericValue(revMax.toCharArray()[i]) + Character.getNumericValue(revMin.toCharArray()[i]);
				sb.append(sum%2);
				carry = sum/2;
			}else{
				int sum = carry + Character.getNumericValue(revMax.toCharArray()[i]);
				sb.append(sum%2);
				carry = sum/2;
			}
			
		}
		
		return carry == 1? "1" + sb.reverse().toString():sb.reverse().toString();
	}
}
