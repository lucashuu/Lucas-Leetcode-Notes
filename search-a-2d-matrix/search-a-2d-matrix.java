class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]){
            return false;
        }
        int n = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n]){
                int start = 0; int end = n;
                while(start + 1 < end){
                    int mid = start + (end - start) / 2;
                    if(matrix[i][mid] == target){
                        start = mid;
                    }if(matrix[i][mid] < target){
                        start = mid;
                    }else{
                        end = mid;
                    }
                }
                if(matrix[i][end] == target){
                    return true;
                }else if(matrix[i][start] == target){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}