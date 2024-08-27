class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m-1;
        int second = n-1;
        int ansPtr = m+n-1;
        
        while(first >= 0 && second >= 0){
            if(nums1[first] > nums2[second]){
                nums1[ansPtr--] = nums1[first--];
            }else{
                nums1[ansPtr--] = nums2[second--];
            }
        }
            
        while(second >= 0){
            nums1[ansPtr--] = nums2[second--];
        }
        
    }
}