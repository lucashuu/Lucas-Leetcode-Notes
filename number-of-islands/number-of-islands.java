class Solution {
//dfs
//find a 1 and dfs the 
//if the node is one chage it to count 
//hit 0 break and find another one 
    private int n;
    private int m;
    private int count;
    private int[] x = new int[]{-1, 0, 1, 0};
    private int[] y = new int[]{0, -1, 0, 1};
    public int numIslands(char[][] grid) {
        if(grid.length ==  0 || grid == null){
            return 0;
        }
        n = grid.length;
        m = grid[0].length;
        count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }else{
                    continue;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i , int j){
        // if it is not valid or 越界 retrun
      
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        }
        // search for the neighbors 
        for(int k = 0; k < x.length; k++){
            int dx = x[k] + i;
            int dy = y[k] + j;
            if(dx < 0 || dx >= n || dy < 0 || dy >= m || grid[dx][dy] == '0'){
                continue;
            }else{
                  dfs(grid, dx, dy);
             }
           
        }
    }
}