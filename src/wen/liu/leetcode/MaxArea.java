package wen.liu.leetcode;

/**
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
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
