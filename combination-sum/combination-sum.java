class Solution {
    List<List<Integer>> res;
    List<Integer> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }
    public void dfs(int[] candidates, int target, int Index){
        if(target == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target < 0){
            return;
        }
        if(target > 0){
            //对于所有的选择 pos 不自增
           for(int i = Index; i < candidates.length; i++){
              
               ans.add(candidates[i]);
                
               dfs(candidates, target - candidates[i], i);
               
               ans.remove(ans.size() - 1);
           }
            
        }
        
        
    }
}