class Solution {
    //运用 dfs 染色
    // 根据二分图 定义 我们发现 给一个节点和其相邻的节点染 相反的色 如果是二分图则 遍历完整张图 回到原节点的时候 会同样的颜色
    // dfs node 如果node 已经染色则查看现在要染的色 跟之前一不一样 如果不一样则 return false 如果一样则 继续 递归 pre order traverse
  
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0){
            return false;
        }
        //construct graph
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
       
        return dfs(graph, 0, 1, visited);
    }
    public boolean dfs(int[][] graph, int node, int color, int[] visited){
        //if node has already been colored check
       if(visited[node] != 0){
           return visited[node] == color;
       }
          visited[node] = color;
        // for all the neighbor
        for(int nei: graph[node]){
            if( !dfs(graph, nei, -color, visited)){
              return false;
            }
        }
        return true;
    }
}