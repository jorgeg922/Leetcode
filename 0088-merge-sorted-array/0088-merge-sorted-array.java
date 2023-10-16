class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size1 = m;
        int size2 = n;
        
        int[] mergedArray = new int[nums1.length];
        int z = 0;
        
        int i = 0;
        int j = 0;
        
        while(i < size1 && j < size2){
            if(nums1[i] < nums2[j]){
              mergedArray[z++] = nums1[i++];  
            }else{
                mergedArray[z++] = nums2[j++];
            }
        }
        
        if(i<size1){
            while(i<size1){
                mergedArray[z++]=nums1[i++];
            }
        }
        
        if(j<size2){
            while(j<size2){
                mergedArray[z++]=nums2[j++];
            }
        }
        
        int tmp = 0;
        for(int num : mergedArray){
            nums1[tmp++]=num;
        }

    }
}