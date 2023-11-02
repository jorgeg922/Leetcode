class Solution {  
    HashMap<Character,int[]> ranking = new HashMap<>();
    public String rankTeams(String[] votes) {
        int teamsSize = votes[0].length();
        for(String vote : votes){
            int len = vote.length();
            for(int i=0; i<len; i++){
                char currentTeam = vote.charAt(i);
                if(!ranking.containsKey(currentTeam)){
                    ranking.put(currentTeam, new int[teamsSize]);
                }
                
                int[] scores = ranking.get(currentTeam);
                scores[i] += 1;
                ranking.put(currentTeam,scores);
            }
        }
        
        PriorityQueue<Character> sortedTeams = new PriorityQueue<>(new Comparator<>(){
            public int compare(Character a, Character b){
                for(int i=0; i<teamsSize; i++){
                    if(ranking.get(a)[i] > ranking.get(b)[i]){
                        return 1;
                    }else if(ranking.get(a)[i] < ranking.get(b)[i]){
                        return -1;
                    }
                }
                
                //if equals all throughout
                return b.compareTo(a);
            }
        });
    
        for(Character team : ranking.keySet()){
            sortedTeams.add(team);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!sortedTeams.isEmpty()){
            sb.append(sortedTeams.poll());
        }
        
        return sb.reverse().toString();
    }     
}