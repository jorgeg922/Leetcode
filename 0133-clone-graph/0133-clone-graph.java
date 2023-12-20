/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inQueue = new HashSet<>(); //keeps track of items in q in case it processes node with same neighbors
        visited.add(node.val);
        inQueue.add(node.val);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            inQueue.remove(curr.val);
            
            if(!map.containsKey(curr.val)){
                 map.put(curr.val, new Node(curr.val));
            }
           
            
            for(Node neighbor : curr.neighbors){
               
                if(!map.containsKey(neighbor.val)){
                    map.put(neighbor.val, new Node(neighbor.val));
                }
                
                Node newNeighbor = map.get(neighbor.val);
                
                map.get(curr.val).neighbors.add(newNeighbor);
                
                if(!visited.contains(neighbor.val) && !inQueue.contains(neighbor.val)){
                    q.add(neighbor);
                    visited.add(neighbor.val);
                    inQueue.add(neighbor.val);
                }                
            }
        }
        
        
      return map.get(node.val);  
    }
}
