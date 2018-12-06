package wen.liu.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 *	s 可能为空，且只包含从 a-z 的小写字母。
 *  p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 */
public class Regex2 {
	public static void main(String[] args) {
		try{
//			String s="aassdddddddd";
//			String p="a*sa*.*s*.*sd*";
			String s="bbaab";
			String p="*?aab";
			System.out.println(isMatch(s, p));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;

        char asterisk='*';
        if("".equals(s)){
        	if("".equals(p)){
        		return true;
        	}else{
        		int j = p.length();
        		while(j-->0){
        			if(p.charAt(j)!=asterisk)
        				return false;
        		}
        		return true;
        	}
        }else if("".equals(p)){
        	return false;
        }
        
        char qmark='?';
        int lens = s.length()-1;
        int lenp = p.length()-1;
        
        int i=0,j=0;
        while(i<=lens && j<=lenp){
        	char c=s.charAt(i),r=p.charAt(j);
    		if(c==r || r==qmark){
    			if(i==lens && j==lenp){
    				return true;
    			}else if(i==lens && j<lenp){
    				return isMatch("", p.substring(j+1));
    			}else if(j==lenp && i<lens){
    				return false;
    			}
    			i++;j++;
        	}else if(r==asterisk){
        		if(j==lenp) return true;

        		while(j++<lenp && p.charAt(j)==asterisk){}
        		if(j>lenp) return true;
        		
    			String np = p.substring(j);
    			do{
    				if(isMatch(s.substring(i), np)){
    					return true;
    				}
    			}while(i++<lens);
    			return false;
        	}else{
        		return false;
        	}
    	}
    	return false;
    }
}
