class Solution {
    // BFS找最短路径
    // 两种思路： 
    // 1:  找到所有1 然后找离得最近的0的距离 // 最坏 需要遍历所有 1 然后 每个1 要遍历所有的格子 O（mn^2)

    // 2:  从0开始 然后找离的最近的1   两遍遍遍历所有格子 O(2mn)
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        // Queue to push all the 0 node
        // pull the node if it is not 0 and valid , traverse all the direction 
        // get the count of the distant and and update in res
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] x = new int[]{-1, 0 , 1, 0};
        int[] y = new int[]{0, -1, 0, 1};
        int cost = 0;
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int[] temp = q.poll();
                int xd = temp[0];
                int yd = temp[1];
                // 4 direction and find the nearest dis to get a 1
                if(mat[xd][yd] == 1){
                    res[xd][yd] = cost;
                }
                for(int j = 0; j < x.length; j++){
                    int xt = xd + x[j];
                    int yt = yd + y[j];
                        System.out.println(xt);
                        System.out.println(yt);
                    if(xt >= 0 && yt >= 0 && xt < mat.length && yt < mat[0].length){
                        if(!visited[xt][yt] ){
                            q.offer(new int[]{xt, yt});
                            visited[xt][yt] = true;
                            
                        }
                    }
                    }
                }
                cost++;
            }
            
          return res;  
        }
    }
