//      a d c e b    * a ? b
/*   去掉s首字母
    d c e b || * a ? b
去掉s首字母              去掉p的*       
c e b  ||  * a ? b      d c e b || a ? b
                     去掉s的首字母      
                     c e b || a ? b

dfs
// 1. 遇到 当前字母相同 或者？ 则直接 i++, j++
// 2. 遇到 * 则有两种情况 1. s第一个字母移去， p第一个字母移去
//  递归的检查, 如果当前 i == length j == length 返回true
//   如果 j != length 递归检查下一位是不是 * 是 * 就继续递归
*/
//普通dfs 超时, 用备忘录减枝
class Solution {
    int[][] v;
    public boolean isMatch(String s, String p) {
            if(s.length() == 0 || s == null){
                if(p.length() == 0 || p == null){
                    return true;
                }
            }  
            v = new int[s.length()][p.length()];
            return helper(s, p, 0 , 0);
    }
    public boolean helper(String s, String p, int i, int j){
        if(i == s.length() && j == p.length()){
            return true;
        }
        if( i < s.length() && j== p.length()){
            return false;
        }
        if (i == s.length() && j < p.length()){
            if(p.charAt(j) == '*'){
                return helper(s, p , i , j + 1);
            }else{
                return false;
            }
        }
        if (v[i][j] != 0) return v[i][j] == 1;
        boolean ans = false;
        if(i < s.length() && j < p.length()){
            if(p.charAt(j) == '*'){
                ans =  helper(s, p, i + 1, j) || helper(s, p, i , j + 1);
            }else if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'){
                ans =  helper(s, p, i+1, j+1);
            }
            v[i][j] = (ans) ? 1 : -1;
        }
        return ans;
    }
}