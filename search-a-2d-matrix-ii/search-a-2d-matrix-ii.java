//类似于二分的做饭
//如果小于当前数 则上移一行
//如果大于当前数 则右移一列
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length -1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(matrix[row][col] < target){
                col++;
            }else if(matrix[row][col] > target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}