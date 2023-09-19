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
        Map<Integer, Node> nodeMap = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();   
        q.add(node);
        
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inQueue = new HashSet<>();
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(inQueue.contains(curr.val)){
                inQueue.remove(curr.val);
            }
            if(!nodeMap.containsKey(curr.val)){
                nodeMap.put(curr.val, new Node(curr.val));
            }
            
            List<Node> neighbors = curr.neighbors;
            for(Node neighbor : neighbors){
                if(!visited.contains(neighbor.val) && !inQueue.contains(neighbor.val)){
                    q.add(neighbor);
                    inQueue.add(neighbor.val);
                }
                
                if(!nodeMap.containsKey(neighbor.val)){
                    nodeMap.put(neighbor.val, new Node(neighbor.val));
                }
                nodeMap.get(curr.val).neighbors.add(nodeMap.get(neighbor.val));
            }
            visited.add(curr.val);
        }
        
        return nodeMap.get(node.val);
    }
}