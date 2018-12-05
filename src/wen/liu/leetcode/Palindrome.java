package wen.liu.leetcode;

public class Palindrome {
	public static void main(String[] args) {
		String s = "zzbababsss";
		System.out.println(longestPalindrome(s));
	}
	
	public static String longestPalindrome(String s) {
		if(s==null) return null;
		if(s.length()<2) return s;
		
		int len = s.length();
        int start=0,end=0;
        int max=0;
        for(int i=0;i<len-1;i++){
        	if(len-i<=max) 
        		break;
        	for(int j=s.length()-1;j>0;j--){
        		if(j-i+1<=max) 
        			break;
        		int b=i,e=j;
        		boolean isPalindrome = true;
        		while(b<e){
        			if(s.charAt(b++) != s.charAt(e--)){
        				isPalindrome = false;
        				break;
            		}
        		}
        		if(isPalindrome){
        			max = Math.max(max, j-i+1);
        			start=i;
        			end=j;
        		}
        	}
        }
		return max>0?s.substring(start, end+1):s.substring(0, 1);
    }
}
