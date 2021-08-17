class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        //termiation case
        //parentheses == n 的时候 加入 res
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb);
        return ans;
    }
    public void dfs(int leftP, int rightP, StringBuilder sb){
        //termination case
        if(leftP < 0 || rightP < 0){
            return;
        }
        //if right < left invalid parenthese
        if(rightP < leftP){
            return;
        }
        if(leftP == 0 && rightP == 0){
            
              ans.add(sb.toString());  
            
            return;
        }
        //每一个possibilities 
        //memorize the state 
        //回溯
        dfs(leftP - 1, rightP, sb.append('('));
        //remove the state
        sb.delete(sb.length() - 1, sb.length());
        dfs(leftP, rightP - 1, sb.append(')'));
        sb.delete(sb.length() - 1, sb.length());
        //因为没有对left 和 right 直接-- 所以 数没变 不用撤回
    }
}