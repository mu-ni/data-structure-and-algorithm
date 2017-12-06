package leet.code.easy;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MMMCMXCIX"));//3999
	}
	
    public static int romanToInt(String s) {
        int rst = 0;
        String str = s;
        
        if(s.indexOf("IV") != -1){rst -= 2;}//4 = 1+5-2
        if(s.indexOf("IX")!=-1){rst-=2;}//9 = 1+10-2
        if(s.indexOf("XL")!=-1){rst-=20;}//40 = 10+50-20
        if(s.indexOf("XC")!=-1){rst-=20;}//90 = 10+100-20
        if(s.indexOf("CD")!=-1){rst-=200;}//400 = 100+500-200
        if(s.indexOf("CM")!=-1){rst-=200;}//900 = 100+1000-200
        
        for(int i=0;i<str.length();i++){
        	switch(s.substring(0,1)){
        	case "I":
        		rst += 1;
        		break;
        	case "V":
        		rst += 5;
        		break;
        	case "X":
        		rst += 10;
        		break;
        	case "L":
        		rst += 50;
        		break;
        	case "C":
        		rst += 100;
        		break;
        	case "D":
        		rst += 500;
        		break;
        	case "M":
        		rst += 1000;
        		break;        	
        	}
        	s = s.substring(1);
        }
    	
    	return rst;
    }
}
