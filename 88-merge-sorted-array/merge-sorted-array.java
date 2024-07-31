class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int rightmost = m + n - 1;
        int nums1_ptr = m - 1;
        int nums2_ptr = n - 1;
        
        while(nums1_ptr >=0 && nums2_ptr >= 0){
            if(nums1[nums1_ptr] > nums2[nums2_ptr]){
                nums1[rightmost--] = nums1[nums1_ptr--];
            }else{
                nums1[rightmost--] = nums2[nums2_ptr--];
            }
        }
        
        while(nums2_ptr >= 0){
            nums1[rightmost--] = nums2[nums2_ptr--];
        }
    }
}

/*
[0]
[4]


*/