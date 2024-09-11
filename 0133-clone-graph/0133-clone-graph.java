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
        if(node == null) return node;
        Queue<Node> q = new LinkedList<>();
        Map<Node,Node> hm = new HashMap<>();
        hm.put(node,new Node(node.val));
        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.poll();
            Node clone = hm.get(temp);
            for(Node neighbour : temp.neighbors){
                if(!hm.containsKey(neighbour)){
                    hm.put(neighbour,new Node(neighbour.val));
                    q.add(neighbour);
                }
                clone.neighbors.add(hm.get(neighbour));
            }
        }
        return hm.get(node);
    }
}