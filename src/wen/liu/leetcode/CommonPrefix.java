package wen.liu.leetcode;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
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
