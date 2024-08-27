class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair<Character,Integer> a, Pair<Character,Integer> b){
                return b.getValue() - a.getValue();
            }
        });
        
        Queue<Pair<Character,Integer>> q = new LinkedList<>();
        
        Map<Character, Integer> freq = new HashMap<>();
        
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            pq.add(new Pair<Character,Integer>(entry.getKey(), entry.getValue()));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair<Character,Integer> curr = pq.poll();
            sb.append(curr.getKey());
            
            if(!q.isEmpty()){
                pq.add(q.poll());
            }
            
            if(curr.getValue()-1 > 0){
                q.add(new Pair<Character,Integer>(curr.getKey(), curr.getValue()-1));
            }
            
        }
        
        if(!q.isEmpty()){
            return "";
        }
        
        return sb.toString();
        
    }
}