class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int[] finalPrices = new int[prices.length];        
        
        for(int i=0; i<prices.length; i++){
            
                while(!stack.isEmpty() && stack.peek().getValue() >= prices[i]){
                    Pair<Integer,Integer> curr = stack.pop();
                    finalPrices[curr.getKey()] = curr.getValue() - prices[i];
                }
                stack.push(new Pair(i,prices[i]));
            
        }
        
        while(!stack.isEmpty()){
            Pair<Integer,Integer> curr = stack.pop();
            finalPrices[curr.getKey()] = curr.getValue();
        }
        
        return finalPrices;
    }
}