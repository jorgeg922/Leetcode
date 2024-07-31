class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total_len = m + n - 1;
        int nums1_len = m-1;
        int nums2_len = n-1;
        
        while(nums1_len >= 0 && nums2_len >=0){
            if(nums1[nums1_len] > nums2[nums2_len]){
                nums1[total_len--] = nums1[nums1_len--];
            }else{
                nums1[total_len--] = nums2[nums2_len--];
            }
        }
        
        while(nums2_len >= 0){
            nums1[total_len--] = nums2[nums2_len--];
        }
    }
}