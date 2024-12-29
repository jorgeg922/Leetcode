class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;

        int[] maxLeftScore = new int[n];
        maxLeftScore[0] = values[0];
        int maxScore = 0;

        for(int i=1; i<values.length; i++){
            int score = maxLeftScore[i-1] + values[i] - i;
            maxScore = Math.max(maxScore, score);
            maxLeftScore[i] = Math.max(maxLeftScore[i-1], values[i] + i);
        }


        return maxScore;
    }
}