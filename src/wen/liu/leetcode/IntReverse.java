package wen.liu.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class IntReverse {
	public static void main(String[] args) {
		try{
			int s=-1234567892;
			System.out.println(reverse(s));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static int reverse(int x) {
        int num=x<0?-x:x;
        long result=0;
        while(num != 0){
        	int r = num%10;
        	if(r>0){
        		if(result>0)
        			result *= 10;
        		result += r;
        	}else if(result>0){
        		result *= 10;
        	}
        	num /= 10;
        }
        
        if(x>=0){
        	return result>Integer.MAX_VALUE?0:(int)result;
        }else{
        	return -result<Integer.MIN_VALUE?0:-(int)result;
        }
    }
}
