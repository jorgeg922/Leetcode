class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> frequency = new HashMap<>();
        
        for(String word : words){
            if(!frequency.containsKey(word)){
                frequency.put(word,0);
            }
            frequency.put(word, frequency.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> topKWords = new PriorityQueue<>(new Comparator<>(){
            public int compare(String a, String b){
               if(frequency.get(a) == frequency.get(b)){
                   return b.compareTo(a);
               }
                
                return frequency.get(a) - frequency.get(b);
                
            }
        });
        
        for(String entry : frequency.keySet()){
            topKWords.add(entry);
            if(topKWords.size() > k){
                topKWords.poll();
            }
        }
        
        List<String> topWords = new ArrayList<>();
        while(!topKWords.isEmpty()){
            topWords.add(topKWords.poll());
        }
        
        Collections.reverse(topWords);
        return topWords;
        
    }
}