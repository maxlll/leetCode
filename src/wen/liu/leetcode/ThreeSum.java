package wen.liu.leetcode;

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
			int[] s={};
			System.out.println(threeSum(s));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
		return null;
    }
}
