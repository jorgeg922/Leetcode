class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n-1;
        int n1 = m-1;
        int n2 = n-1;
        
        while(n1 >= 0 && n2 >= 0){
            if(nums1[n1] > nums2[n2]){
                nums1[l--] = nums1[n1--];
            }else{
                nums1[l--] = nums2[n2--];
            }
        }
        
        while(n2 >= 0){
            nums1[l--] = nums2[n2--];
        }
        
    }
}