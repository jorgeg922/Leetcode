class Solution {
    public String rankTeams(String[] votes) {
        HashMap<Character,int[]> votesPerTeam = new HashMap<>();
        int positions = votes[0].length();
        
        for(int i=0; i<positions; i++){
            votesPerTeam.put(votes[0].charAt(i), new int[positions]);
        }
        
        for(String vote : votes){
            char[] currentVotes = vote.toCharArray();
            for(int i=0; i<currentVotes.length; i++){
                char team = currentVotes[i];
                int[] teamVotes = votesPerTeam.get(team);
                teamVotes[i]++;
                votesPerTeam.put(team, teamVotes);
            }
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Character a, Character b){
                int[] teamAVotes = votesPerTeam.get(a);
                int[] teamBVotes = votesPerTeam.get(b);
                
                for(int i=0; i<positions; i++){
                    if(teamAVotes[i] != teamBVotes[i]){
                        return teamBVotes[i] - teamAVotes[i];
                    }
                }
                
                return a.compareTo(b);
            }
        });
        
        for(char t : votesPerTeam.keySet()){
            pq.add(t);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        return sb.toString();
    }
}