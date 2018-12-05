package wen.liu.leetcode;

public class Zconvert {
	public static void main(String[] args) {
		try{
			String s= "SATRFFDFGDFGDFGERTNMKPDJGBVZXOIEMNVHASERLMVJFD";
			String sc = convert2(s, 4);
			System.out.println(sc);
//			System.out.println(sc.equals("LDREOEIIECIHNTSG"));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static String convert(String s, int numRows) {
        if(s==null || numRows<2) return s;
        
        int len = s.length();
        int size = numRows + numRows - 2;
        int num = (len-1)/size + 1;
        StringBuilder br = new StringBuilder();
        for(int i=0;i<numRows;i++){
        	for(int j=0;j<num;j++){
        		int index = i+j*size;
        		if(index < len)
        			br.append(s.charAt(index));
        		if(i!=0 && i!=numRows-1){
        			int a = size-i;
            		if(a+j*size < len){
            			br.append(s.charAt(a+j*size));
            		}
        		}
        	}
        }
        return br.toString();
    }
	
	public static String convert2(String s, int numRows) {
        if(s==null || numRows<2) return s;
        
        System.out.println(s);
        int len = s.length();
        int size = numRows + numRows - 2;
        int num = (len-1)/size + 1;
        StringBuilder br = new StringBuilder();
        for(int i=0;i<numRows;i++){
            StringBuilder line = new StringBuilder();
        	for(int j=0;j<num;j++){
        		int index = i+j*size;
        		if(index < len){
        			br.append(s.charAt(index));
        			line.append(s.charAt(index)).append(" ");
        		}
        		if(i!=0 && i!=numRows-1){
        			int m = size-numRows-i;
        			while(m-->0){
        				line.append(" ");
        			}
        			int a = size-i;
            		if(a+j*size < len){
            			br.append(s.charAt(a+j*size));
            			line.append(s.charAt(a+j*size)).append(" ");
            		}
            		m = i-1;
        			while(m-->0){
        				line.append(" ");
        			}
        		}else if(j<num-1){
        			int m = size-numRows;
        			while(m-->0){
        				line.append(" ");
        			}
        			line.append(" ");
        		}
        	}
        	System.out.println(line.toString());
        }
        return br.toString();
    }
}
