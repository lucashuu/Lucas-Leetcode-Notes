class Solution {
    int n;
    int m;
    int[] x = {-1, 0 , 1, 0};
    int [] y = {0 , -1, 0 , 1};
    //use a used array to cut left
    //if the spot of the board has been reached no need to reach it again 
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][] used =  new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i , j, 0, used)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int pos, boolean[][] used){
     
        if(pos == word.length()){
             
            return true;
            //所有的字母都被匹配
        }
        if(i < 0 || j < 0 || i >= n || j >= m || 
         board[i][j] != word.charAt(pos) || used[i][j]){
            return false;
        }
        
            //For all possiblities 
            used[i][j] = true;
            for(int k = 0; k < 4; k++){     
                int xd = i + x[k];
                int yd = j + y[k]; 
              
                     if(dfs(board, word, xd, yd, pos + 1, used)){
                         return true;
                     }
        }
        used[i][j] = false;
        return false;
    }
}