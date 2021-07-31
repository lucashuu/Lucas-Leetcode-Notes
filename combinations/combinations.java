class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, k, n);
        return res;
    }
    public void dfs(int pos, int k, int n){
        if(ans.size() == k){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = pos; i <= n; i++){
            ans.add(i);
            dfs(i + 1, k, n);
            ans.remove(ans.size() - 1);
        }
    }
}