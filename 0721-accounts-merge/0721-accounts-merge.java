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
                List<String> records = new ArrayList<>();
                records.add(accounts.get(i).get(0));
                dfs(i, accounts, visited, new HashSet<String>(), records);
                Collections.sort(records.subList(1, records.size()));
                ans.add(records);
            }
        }
        
        return ans;
    }
    
    public void dfs(int index, List<List<String>> accounts, Set<Integer> visited, Set<String> group, List<String> records){        
        visited.add(index);
        for(int i=1; i<accounts.get(index).size(); i++){ 
            if(!group.contains(accounts.get(index).get(i))){
                group.add(accounts.get(index).get(i)); 
                records.add(accounts.get(index).get(i));
            }
                
        }
        for(int neighbor : graph.get(index)){
            if(!visited.contains(neighbor)){
                dfs(neighbor, accounts, visited, group, records);                
            }
        }                
    }
}