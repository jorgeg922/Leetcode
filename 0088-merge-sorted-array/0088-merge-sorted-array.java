class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int num : nums2){
            nums1[m++]=num;
        }
        Arrays.sort(nums1);
    }
}