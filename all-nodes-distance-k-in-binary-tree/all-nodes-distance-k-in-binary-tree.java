/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    HashMap<Integer, List<Integer>> map;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        int k2 = 0;
        
        
        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        cGraph(root);
        q.offer(target.val);
        visited.add(target.val);
        
        while(!q.isEmpty()){
            int qlen = q.size();
            for(int i = 0; i < qlen; i++){
                int node = q.poll();
                
                if(k2 == k){
                    res.add(node);
                    
                }
                List<Integer> temp = new ArrayList<>(map.getOrDefault(node, new ArrayList<Integer>()));
                for(int j = 0; j < temp.size(); j++){
                    if(!visited.contains(temp.get(j))){
                        q.offer(temp.get(j));
                        visited.add(temp.get(j));
                    }
                    
                }
            }
            ++k2;
        }

      if(k2 < k){
          return new ArrayList<Integer>();
      }
           return res;
       
        
    }
    //建图
    public void cGraph(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left != null){
           add(root, root.left);
           cGraph(root.left);
        }
        if(root.right != null){
            add(root, root.right);
            cGraph(root.right);
        }
        
    }
    public void add(TreeNode a, TreeNode b){
        List<Integer> c = map.getOrDefault(a.val, new ArrayList<Integer>());
        List<Integer> d = map.getOrDefault(b.val, new ArrayList<Integer>());
        c.add(b.val);
        d.add(a.val);
        map.put(a.val, c);
        map.put(b.val, d);
    }
}