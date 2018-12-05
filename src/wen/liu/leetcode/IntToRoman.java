package wen.liu.leetcode;

/**
 * 整数转罗马数字
 */
public class IntToRoman {
	public static void main(String[] args) {
		try{
			int s=1994;
			System.out.println(intToRoman(s));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static String intToRoman(int num) {
		if(num<1 || num>3999){
			return "";
		}
		
        int[] real = {1000, 500, 100, 50,  10,   5,   1};
        char[] roma = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder s = new StringBuilder();
        for(int i=0;i<roma.length;i++){
        	char c = roma[i];
        	if(num>=real[i]){
        		int b = num/real[i];
        		if(b<4){
        			for(int j=0;j<num/real[i];j++){
            			s.append(c);
            		}
            		num %= real[i];
        		}
        	}
    		if(i<2){
    			if(num >= real[i]-real[2]){
    				s.append(roma[2]).append(roma[i]);
    				num -= (real[i]-real[2]);
    			}
    		}else if(i>=2 && i<4){
    			if(num >= real[i]-real[4]){
    				s.append(roma[4]).append(roma[i]);
    				num -= (real[i]-real[4]);
    			}
    		}else if(i>=4 && i<6){
    			if(num >= real[i]-real[6]){
    				s.append(roma[6]).append(roma[i]);
    				num -= (real[i]-real[6]);
    			}
    		}
        }
		return s.toString();
    }
}
