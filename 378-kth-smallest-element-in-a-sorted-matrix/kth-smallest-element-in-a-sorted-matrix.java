class Solution {
    class Node{
        int val;
        int row;
        int col;

        public Node(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(Math.min(n, k), new Comparator<>() {
            public int compare(Node a, Node b){
                return a.val - b.val;
            }
        });

        for(int i=0; i<Math.min(n, k); i++){
            pq.add(new Node(matrix[i][0], i, 0));
        }

        Node element = pq.peek();

        while(k-- > 0){
            element = pq.poll();

            if(n - element.col > 1){
                pq.add(new Node(matrix[element.row][element.col+1], element.row, element.col + 1));
            }
        }

        return element.val;

    }
}