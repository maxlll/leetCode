package wen.liu.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class CommonPrefix {
	public static void main(String[] args) {
		try{
			String[] s={"LVIII"};
			System.out.println(longestCommonPrefix(s));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
        	return "";
        }
        
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
        	String str = strs[i];
        	int len = Math.min(prefix.length(), str.length());
        	int j=0;
        	for(;j<len;j++){
        		if(prefix.charAt(j)!=str.charAt(j)){
        			if(j==0){
        				return "";
        			}
        			break;
        		}
        	}
        	prefix = prefix.substring(0, j);
        }
		return prefix;
    }
}
