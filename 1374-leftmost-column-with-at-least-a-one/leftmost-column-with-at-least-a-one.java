/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    BinaryMatrix binaryMatrix;
    List<Integer> dim;
    int rows;
    int cols;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        this.binaryMatrix = binaryMatrix;
        this.dim = binaryMatrix.dimensions();
        this.rows = dim.get(0);
        this.cols = dim.get(1);
        int leftmost = Integer.MAX_VALUE;
        
        for(int row=0; row<rows; row++){
            int l = bs(row);
            leftmost = Math.min(leftmost,l);
        }
        
        return leftmost==Integer.MAX_VALUE?-1:leftmost;
    }
    
    public int bs(int row){
        int left = 0;
        int right = cols-1;
        
        while(left < right){
            int mid = left+(right-left)/2;
            int val = binaryMatrix.get(row,mid);
            
            if(val <= 0){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        
        if(binaryMatrix.get(row,left) == 1){
            return left;
        }
        return Integer.MAX_VALUE;
    }
}