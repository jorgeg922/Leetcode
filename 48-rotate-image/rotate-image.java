class Solution {
    public void rotate(int[][] matrix) { 
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int row=0; row<matrix.length; row++){        
            for(int col = row; col < matrix[row].length; col++){
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
        
        for(int row=0; row<matrix.length; row++){
            int left = 0;
            int right = matrix[0].length-1;
            
            while(left < right){
                int tmp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = tmp;
                
                left++;
                right--;
            }
        }
    }
}