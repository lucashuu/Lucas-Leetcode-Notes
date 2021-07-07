/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BFS 建立队列 不管root的左右是不是null 都加入队列里
//出队的时候如果是null 则加入NULL 到 string 里 
//不是null则加入node 的 val
//值与值之间用, 分割
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){return "";}
        sb.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int qlen = q.size();
            for(int i = 0; i < qlen; i++){
                TreeNode node = q.poll();
                if(node == null){
                    sb.append("null");
                }else{
                    sb.append(node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                }
                    sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){return null;}
        String[] datalist = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(datalist[0]));
        q.offer(node);
        int i = 1;
        while(!q.isEmpty()){
                TreeNode node1 = q.poll();
                if(!"null".equals(datalist[i])){
                    node1.left = new TreeNode(Integer.parseInt(datalist[i]));
                    q.offer(node1.left);
                }
                i++;
                if(!"null".equals(datalist[i])){
                    node1.right = new TreeNode(Integer.parseInt(datalist[i]));
                    q.offer(node1.right);
                }
                i++;
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));