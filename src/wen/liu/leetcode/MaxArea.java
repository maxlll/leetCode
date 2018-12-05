package wen.liu.leetcode;

/**
 * ʢ���ˮ������
 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * �������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * ˵�����㲻����б�������� n ��ֵ����Ϊ 2��
 */
public class MaxArea {
	public static void main(String[] args) {
		try{
			int[] s={1,8,6,2,5,4,8,3,7};
			System.out.println(maxArea(s));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static int maxArea(int[] height) {
        int x=0;
        int len= height.length;
        for(int i=0;i<len-1;i++){
        	x = Math.max(x, Math.min(height[i], height[i+1]));
        }
        for(int i=0;i<len-1;i++){
        	if(height[i]==0) continue;
        	int m = x/height[i];
        	for(int j=i+m;j<len;j++){
        		x = Math.max(Math.min(height[i], height[j])*(j-i), x);
        	}
        }
		return x;
    }
}
