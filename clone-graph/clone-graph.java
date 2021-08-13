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
    private HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
       if (node  == null){
            return node;
        }
        Node newNode = dfs(node);
        return newNode;
    }
    public Node dfs(Node node){
        if(node == null){
            return node;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }else{
          Node newNode = new Node(node.val);
          map.put(node, newNode);  
        

        
        List<Node> list = new ArrayList<>();
        for(Node nei : node.neighbors){
            
            Node cur = dfs(nei);
            list.add(cur);
            
        }
         newNode.neighbors = list;
          return newNode;
        }
        
          
    }
}
