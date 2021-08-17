class Solution {
    List<Integer> ans;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 给的数组有重复
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        res = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, target, 0, used);
        return res;
    }
    public void dfs(int[] nums, int target, int Index, boolean[] used){
        //termination case
        if(target == 0){
            //if the target equls to 0 add to res
            res.add(new ArrayList<>(ans));
            return;
        }
       
        // for all the possibilities
        for(int i = Index; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                continue;
            }
            // memorize the state
            // recursion 
            int diff = target - nums[i];
            
            if(diff >= 0){
                ans.add(nums[i]);
                used[i] = true;
                dfs(nums, diff, i + 1, used); 
                used[i] = false;
                ans.remove(ans.size() - 1);
            }else{
                continue;
            }
            
        }
    }
}