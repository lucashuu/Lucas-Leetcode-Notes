class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        //隔板法
        //n - 1个隔板 每次分割 字符串 check 是不是 回文
        
        if(s.length() == 0){
            return res;
        }
        dfs(0, s);
        return res;
    }
    public void dfs(int pos, String s){
        if(pos == s.length()){
             res.add(new ArrayList<>(ans));
            return;
        }
       for(int i = pos + 1; i <= s.length() ; i++) {
            if(!validPanlindrome(s.substring(pos, i))){
                continue;
            }
           ans.add(s.substring(pos, i));
            dfs(i, s);
            ans.remove(ans.size() - 1);
        }
    }
    public boolean validPanlindrome(String s){
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;      
    }
}