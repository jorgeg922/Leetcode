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
        
        Map<Node, Node> nodeMap = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();   
        q.add(node);
        
        nodeMap.put(node, new Node(node.val, new ArrayList()));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            List<Node> neighbors = curr.neighbors;
            for(Node neighbor : neighbors){
                if(!nodeMap.containsKey(neighbor)){
                    nodeMap.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    q.add(neighbor);
                }
                nodeMap.get(curr).neighbors.add(nodeMap.get(neighbor));    
            }
            
        }
        
        return nodeMap.get(node);
    }
}