class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = new int[nums1.length + nums2.length];
        
        int i =0;
        
        int nums1Ptr = 0;
        int nums2Ptr = 0;
        
        while(nums1Ptr < nums1.length && nums2Ptr < nums2.length){
            if(nums1[nums1Ptr] < nums2[nums2Ptr]){
                combined[i++]=nums1[nums1Ptr];
                nums1Ptr++;
            }else{
                combined[i++]=nums2[nums2Ptr];
                nums2Ptr++;
            }
        }
        
        if(nums1Ptr < nums1.length){
            while(nums1Ptr < nums1.length){
                combined[i++]=nums1[nums1Ptr++];
            }
        }
        
        if(nums2Ptr < nums2.length){
            while(nums2Ptr < nums2.length){
                combined[i++]=nums2[nums2Ptr++];
            }
        }
        
        if(combined.length % 2 == 0){
            int index = combined.length/2;
            return (double) (combined[index]+combined[index-1])/2;
        }
        
        return combined[combined.length/2];
    }
}

//1 2 3 4 5 6 