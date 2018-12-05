package wen.liu.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Atoi {
	public static void main(String[] args) {
		try{
//			String str = "+-2";
			String str = "0+2";
			System.out.println(myAtoi(str));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static int myAtoi(String str) {
        if(str==null || "".equals(str.trim())){
        	return 0;
        }
        
        int mark=-1;
        int len = (Integer.MAX_VALUE+"").length()+1;
        int[] ns = new int[len];
        for(int i=0;i<len;i++){
        	ns[i] = mark;
        }
        
        str = str.trim();
        boolean isNegative = false;
        boolean hasSymbol = false;
        int index=0;
        for(int i=0;i<str.length();i++){
        	char c=str.charAt(i);
        	if((c>='0' && c<='9')){
    			hasSymbol=true;
        		if(c=='0' && index==0) continue;
    			ns[index++]=c-'0';
        	}else if(c=='-' && !hasSymbol){
        		isNegative=true;
        		hasSymbol = true;
        	}else if(c=='+' && !hasSymbol){
        		hasSymbol = true;
        	}else{
        		break;
        	}
        	
        	if(index==len){
        		break;
        	}
        }
        
        if(ns[len-1]!=mark){
        	return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        
        long result=0;
        boolean hasNum=false;
        for(int i=0;i<len-1;i++){
        	if(ns[i]!=mark){
        		if(hasNum){
        			result *= 10;
        		}else{
        			hasNum=true;
        		}
        		result += ns[i];
        	}
        }
        
        if(result>Integer.MAX_VALUE){
        	return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }else{
        	return isNegative?-(int)result:(int)result;
        }
    }
}
