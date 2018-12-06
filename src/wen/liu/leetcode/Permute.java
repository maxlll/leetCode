package wen.liu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * È«ÅÅÁĞ
 */
public class Permute {
	public static void main(String[] args) {
		try{
			int[] nums = {1, 2, 1, 2};
			System.out.println(permute(nums));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0){
			return list;
		}
		permute(nums, list, 0);
		return list;
    }
	
	private static void permute(int[] nums, List<List<Integer>> list, int start){
		if(start == nums.length-1){
			List<Integer> sub = new ArrayList<>(nums.length);
			for(int a : nums){
				sub.add(a);
			}
			list.add(sub);
		}else{
			for(int i=start;i<nums.length;i++){
				if(isSwap(nums, start, i)){
					continue;
				}
				swap(nums, start, i);
				permute(nums, list, start+1);
				swap(nums, start, i);
			}
		}
	}
	
	private static void swap(int[] nums, int a, int b){
		if(a==b) return;
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	private static boolean isSwap(int[] c, int start, int end){
        for(int i = start; i < end; i++)
            if(c[i] == c[end]) return true;
        return false;
    }
}
