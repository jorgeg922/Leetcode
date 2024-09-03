class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int total = l1+l2;
        int target = (total+1)/2;
        
        int left = 0;
        int right = l1;
        
        while(left <= right){
            int partitionA = left + (right-left)/2;
            int partitionB = target - partitionA;
            
            
            int maxMinHalfA = (partitionA==0)?Integer.MIN_VALUE:nums1[partitionA-1];
            int minMaxHalfA = (partitionA==l1)?Integer.MAX_VALUE:nums1[partitionA];
            int maxMinHalfB = (partitionB==0)?Integer.MIN_VALUE:nums2[partitionB-1];
            int minMaxHalfB = (partitionB==l2)?Integer.MAX_VALUE:nums2[partitionB];
            
            if(maxMinHalfA > minMaxHalfB){
                right = partitionA-1;
                continue;
            }
            
            if(maxMinHalfB > minMaxHalfA){
                left = partitionA + 1;
                continue;
            }
            
            int medianOddCount = Math.max(maxMinHalfA, maxMinHalfB);
            if(total%2 == 0){
                return (medianOddCount + Math.min(minMaxHalfA, minMaxHalfB))/2.0;
            }else{
                return medianOddCount;
            }
        }
        
        return 0.0;
    }
}