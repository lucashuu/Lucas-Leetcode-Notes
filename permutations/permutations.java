class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 1 2 3
        if(nums.length == 0 || nums == null){
            return null;
        }
        dfs( nums);
        return res;
    }
    public void dfs( int[] nums){
        
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(ans.contains(nums[i])){
                continue;
            }
            ans.add(nums[i]);
            dfs(nums);
            ans.remove(ans.size() - 1);
        }
    }
}