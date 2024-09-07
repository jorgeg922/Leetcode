class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){
                int ro = n-1-col;
                int co = n-1-row;
                
                if(row==ro && col==co){
                    break;
                }
                
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[ro][co];
                matrix[ro][co]=tmp;
            }
        }
        
        int left=0;
        int right=n-1;
        
        while(left < right){
            int[] tmp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right]=tmp;
            left++;
            right--;
        }
    }
}