class TopVotedCandidate {
    List<Map<Integer,Pair<Integer,Integer>>> tracker;
    int[] persons;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.tracker = new ArrayList<>();
        Map<Integer,Pair<Integer,Integer>> candidateVotes = new HashMap<>();
        for(int i=0; i<times.length; i++){
            int person = persons[i];
            if(!candidateVotes.containsKey(person)){
                candidateVotes.put(person,new Pair<Integer,Integer>(0,0));
            }
            Pair<Integer,Integer> votes = candidateVotes.get(person);
            int newVotes = votes.getKey() + 1;
            candidateVotes.put(person, new Pair<Integer,Integer>(newVotes,i));
            tracker.add(new HashMap<Integer,Pair<Integer,Integer>>(candidateVotes));
        }
    }
    
    public int q(int t) {        
        int bound = findBound(t);
        Map<Integer,Pair<Integer,Integer>> candidateVotes = tracker.get(bound);
        
        Integer winner = 0;
        Integer winnerVotes = 0;
        Integer winnerIndex = 0;
        for(Map.Entry<Integer,Pair<Integer,Integer>> entry : candidateVotes.entrySet()){
            Pair<Integer,Integer> pair = entry.getValue();
        
            if((Integer)pair.getKey() > winnerVotes){
                winner = entry.getKey();
                winnerVotes = (Integer) pair.getKey();
                winnerIndex = (Integer) pair.getValue();
            }else if((Integer)pair.getKey() == winnerVotes){
                if((Integer)pair.getValue() > winnerIndex){
                    winner = (Integer)entry.getKey();
                    winnerVotes = (Integer)pair.getKey();
                    winnerIndex = (Integer)pair.getValue();
                }
            }
        }
        
        return winner;
    }

    public int findBound(int t){
        int left = 0;
        int right = times.length-1;
        
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(times[mid] == t){
                return mid;
            }
            
            if(times[mid] > t){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return right;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */