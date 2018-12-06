package wen.liu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfStr {
	public static void main(String[] args) {
		try{
			String str = "esasdferts";
			System.out.println(lengthOfLongestSubstring(str));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String reverse(String str){
		char[] chars = str.toCharArray();
		int len = chars.length;
		for(int i=0;i<=len/2;i++){
			chars[i] ^= chars[len-i];
			chars[len-i] ^= chars[i];
			chars[i] ^= chars[len-i];
		}
		return new String(chars);
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int max=0;
        int len=s.length();
        	
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0,j=0;i<len;i++){
        	if(map.containsKey(s.charAt(i))){
        		
        	}
        	
        }
		return max==0?s.length():max;
    }
}
