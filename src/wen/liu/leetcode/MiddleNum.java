package wen.liu.leetcode;

/**
 * 两不全为空的有序数组的中位数
 */
public class MiddleNum {
	public static void main(String[] args) {
		try{
			int[] nums1 = {-2, -1};
			int[] nums2 = {3};
			System.out.println(findMedianSortedArrays(nums1, nums2));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	if(len1+len2<2){
    		//抛异常
    	}
        int num = len1+len2 >>> 1;
        int i=0,j=0;
        while(num>0){
        	if(len1==0 || i==len1 || (len2!=0 && j!=len2 && nums1[i] > nums2[j])){
    			j++;
        	}else{
        		i++;
        	}
        	num--;
        }

		int big = j==len2?nums1[i]:(i==len1?nums2[j]:Math.min(nums1[i], nums2[j]));
        if((len1+len2)%2==0){
        	int little = 0;
    		if(i==0 && j==0){
				little = Math.min(nums1[0], nums2[0]);
    		}else if(i==0){
    			little = nums2[j-1];
    		}else if(j==0){
    			little = nums1[i-1];
    		}else{
    			little = Math.max(nums1[i-1], nums2[j-1]);
    		}
			return (little+big)/2.0;
		}else{
			return big;
		}
    }
}
