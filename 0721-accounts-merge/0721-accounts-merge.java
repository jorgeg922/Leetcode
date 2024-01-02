class Solution {
    HashMap<Integer,List<Integer>> graph;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        HashMap<String,Integer> emailToUser = new HashMap<>();        
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i<accounts.size(); i++){
            graph.put(i, new ArrayList<>());
            List<String> emails = accounts.get(i);
            for(int j=1; j<emails.size(); j++){
                String email = emails.get(j);
                if(!emailToUser.containsKey(email)){
                    emailToUser.put(email, i);
                }else{
                    int otherUser = emailToUser.get(email);
                    graph.get(i).add(otherUser);
                    graph.get(otherUser).add(i);
                }
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++){
            if(!visited.contains(i)){
                List<String> accountsEntry = new ArrayList<>();
                accountsEntry.add(accounts.get(i).get(0));
                dfs(i, accounts, visited, new HashSet<String>(), accountsEntry);
                Collections.sort(accountsEntry.subList(1, accountsEntry.size()));
                ans.add(accountsEntry);
            }
        }
        
        return ans;
    }
    
    public void dfs(int index, List<List<String>> accounts, Set<Integer> visited, Set<String> seenEmail, List<String> accountsEntry){        
        visited.add(index);
        for(int i=1; i<accounts.get(index).size(); i++){ 
            String email = accounts.get(index).get(i);
            if(!seenEmail.contains(email)){
                seenEmail.add(email); 
                accountsEntry.add(email);
            }
                
        }
        for(int nextAccountEntry : graph.get(index)){
            if(!visited.contains(nextAccountEntry)){
                dfs(nextAccountEntry, accounts, visited, seenEmail, accountsEntry);                
            }
        }                
    }
}