package wen.liu.leetcode;


/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 */
public class RomaToInt {
	public static void main(String[] args) {
		try{
			String s="LVIII";
			System.out.println(romanToInt(s));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int romanToInt(String s) {
        if(s==null || "".equals(s)){
        	return 0;
        }
		int[] real = {1000, 500, 100, 50,  10,   5,   1};
        char[] roma = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        
        int result=0;
        int prev=0;
        int start=roma.length-1;
        for(int i=s.length()-1;i>=0;i--){
        	int n1 = 0;
        	for(int j=start;j>=0;j--){
        		if(roma[j]==s.charAt(i)){
        			n1=real[j];
        			start=Math.min(j+2, roma.length-1);
        			break;
        		}
        	}
        	if(n1<prev){
        		result -= n1;
        	}else{
        		result += n1;
        	}
        	prev=n1;
        }
		return result;
    }
}
