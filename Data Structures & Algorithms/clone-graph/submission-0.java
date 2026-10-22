/*
Definition for a Node.
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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node neigh: node.neighbors) {
            if(!map.containsKey(neigh)) {
                Node clone = cloneGraph(neigh);
                map.put(neigh, clone);
                copy.neighbors.add(clone);
            }
            else copy.neighbors.add(map.get(neigh));
        }
        return copy;
    }
}