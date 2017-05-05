public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = (len + 1) / 2;
        int right = (len + 2) / 2 ;
        return (getKthSmallest(nums1, 0, nums2, 0, left) + getKthSmallest(nums1, 0, nums2, 0, right))/2.0;
        
        
            
    }
    
    public int getKthSmallest(int[] nums1, int index1, int[] nums2, int index2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(index1 == len1)
            return nums2[index2 + k - 1];
        if(index2 == len2)
            return nums1[index1 + k - 1];
        if(k == 1)
            return nums1[index1] < nums2[index2] ? nums1[index1] : nums2[index2];
        
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
	    if (index1 + k/2 - 1 < nums1.length) aMid = nums1[index1 + k/2 - 1]; 
	    if (index2 + k/2 - 1 < nums2.length) bMid = nums2[index2 + k/2 - 1];  
	    if (aMid < bMid) 
	        return getKthSmallest(nums1, index1 + k/2, nums2, index2, k - k / 2);
	    else 
	        return getKthSmallest(nums1, index1, nums2, index2 + k/2, k - k / 2);
    }
}