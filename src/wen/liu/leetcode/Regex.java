package wen.liu.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 
 * 说明:
 *	s 可能为空，且只包含从 a-z 的小写字母。
 * 	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class Regex {
	public static void main(String[] args) {
		try{
//			String s="aassdddddddd";
//			String p="a*sa*.*s*.*sd*";
			String s="aab";
			String p="a*b*.*.";
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
        	}else if(p.length()%2==0){
        		int j = p.length()-1;
        		while(j>0){
        			if(p.charAt(j)!=asterisk)
        				return false;
        			j-=2;
        		}
        		return true;
        	}else{
        		return false;
        	}
        }else if("".equals(p)){
        	return false;
        }
        
        char point='.';
        int i=s.length()-1,j=p.length()-1;
    	char c=s.charAt(i),r=p.charAt(j);
    	if(c==r || r==point){
			return isMatch(s.substring(0, i), p.substring(0, j));
    	}else if(r==asterisk){
    		if(j==0) return false;

			char pre = p.charAt(j-1);
			if(pre==point || pre==c){
				if(j==1 && pre==point){
					return true;
				}else{
					String np = p.substring(0, j-1);
					do{
						if(isMatch(s.substring(0, i+1), np)){
							return true;
						}else if(pre==c && i>=0 && s.charAt(i)!=c){
							break;
						}
					}while(i-->=0);
					return false;
				}
			}else{
				return isMatch(s.substring(0, i+1), p.substring(0, j-1));
			}
    	}else{
    		return false;
    	}
    }
}
