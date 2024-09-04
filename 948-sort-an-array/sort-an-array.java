class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void mergeSort(int[] nums,int left,int right){
        if(left < right){
            int mid = left + (right-left)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
                
            merge(nums,left,mid,right);
        }        
    }
    
    public void merge(int[] nums, int left, int mid, int right){
        int len1 = mid-left+1;
        int len2 = right-mid;
        
        int[] tmpL = new int[len1];
        int[] tmpR = new int[len2];
        
        for(int i=0; i<len1; i++){
            tmpL[i] = nums[left+i];
        }
        
        for(int i=0; i<len2; i++){
            tmpR[i] = nums[mid+1+i];
        }
        
        int i=0;
        int j=0;
        int k = left;
        
        while(i<len1 && j<len2){
            if(tmpL[i] < tmpR[j]){
                nums[k++] = tmpL[i++];
            }else{
                nums[k++] = tmpR[j++];
            }
        }
        
        while(i<len1){
            nums[k++] = tmpL[i++];
        }
        while(j<len2){
            nums[k++] = tmpR[j++];
        }
        
    }
}