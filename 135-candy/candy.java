class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] left = new int[size];
        int[] right = new int[size];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        
        for(int i=1; i<left.length; i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        
        for(int i=right.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }
        }
        
        int candies = 0;
        for(int i=0; i<size; i++){
            candies += Math.max(left[i],right[i]);
        }
        
        return candies;
    }
}