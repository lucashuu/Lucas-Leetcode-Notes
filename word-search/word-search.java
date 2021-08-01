class Solution {
    public boolean exist(char[][] board, String word) {
      //用dfs
      //遍历找到开始的点
      //递归 dfs 寻找路径 用|| 减枝
      //创建一个二维数组记录那个方格走过
      //用二维数组记录上下左右四个方向
      if(board.length == 0 || board == null){
          return false;
      }
      int n = board.length;
      int m = board[0].length;
      boolean[][] used = new boolean[n][m];
     for(int i = 0; i < n; i++){
        Arrays.fill(used[i], false);
        }
      // 寻找开始点
      for(int i = 0; i < n; i++){
          
          for(int j = 0; j < m; j++){
              if( dfs(board, word, 0,i, j, used)){
                  
                      return true;
                  
              }
          }
      }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index,int row, int col, boolean[][] used){
        //递归结束条件 , 找到全部的word
        if(index == word.length()){
            return true;
        }
        //如果越界, 当前字母没找到, 当前字母之前已经走过
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || 
         used[row][col]  ||board[row][col] != word.charAt(index)){
            
            return false;
        }
        //用二维数组代表方向 -1,0      0,-1     1,0      0,1
        int[] x = {-1, 0 , 1, 0};
        int [] y = {0 , -1, 0 , 1};
        
        used[row][col] = true;
        for(int i = 0; i < 4; i++){

         if (dfs(board, word, index + 1, row + x[i], col + y[i], used))
             return true;
        }
       
       
        used[row][col] = false;
        
        return false;
    }
}