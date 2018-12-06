package wen.liu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 */
public class ThreeSum {
	public static void main(String[] args) {
		try{
			int[] s={-1,0,1,2,-1,-4};
			System.out.println(threeSum(s));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<3)
        	return list;
        
        Arrays.sort(nums);
        int len = nums.length;

        int prev1=1;
        for(int i=0;i<len;i++){
        	int num1 = nums[i];
        	if(num1 == prev1) continue;
        	if(num1 > 0) break;
        	
        	int prev3 = -1;
        	for(int j=nums.length-1;j>i+1;j--){
        		int num3 = nums[j];
        		if(num3 < 0){
        			break;
        		}else if(num3==0){
        			if(num1==0) addInt(list, num1, 0, num3);
        			break;
        		}else if(num3==prev3 || num1==0){
    				continue;
        		}
        		
        		int sum = num1+num3;
        		int num2 = -sum;
        		
        		if(num2<num1)
        			continue;
        		else if(num2>num3)
        			break;
        		
    	       int low = i+1;
    	       int high = j-1;
    	       while(low<=high){
    	    	   int index = (low+high)>>>1;
        		   if(nums[index] < num2){
        			   low = index+1;
        		   }else if(nums[index]>num2){
        			   high = index-1;
        		   }else{
        			   addInt(list, num1, num2, num3);
        			   break;
        		   }
    	       }
    	       prev3 = num3;
        	}
        	prev1 = num1;
        }
		return list;
    }
	
	private static void addInt(List<List<Integer>> list, int num1, int num2, int num3){
		List<Integer> sub = new ArrayList<Integer>();
		sub.add(num1);
		sub.add(num2);
		sub.add(num3);
		list.add(sub);
	}
}
