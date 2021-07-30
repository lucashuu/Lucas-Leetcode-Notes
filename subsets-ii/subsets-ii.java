class Solution {
    List<List<Integer>> res = new ArrayList<>();
 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //
        if(nums.length == 0 || nums == null){
            return res;
        }
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<Integer>());
        return res;
    }
    public void dfs (int p, int[] nums, List<Integer> ans){
        res.add(new ArrayList<>(ans));
        if(p == nums.length){
            return;
        }
        for(int i = p; i < nums.length; i++){
            if (i > p && nums[i] == nums[i - 1]) {
                continue;
            }
                ans.add(nums[i]);
        
                dfs(i + 1, nums, ans);
                ans.remove(ans.size() - 1);
            
        
        }
        
    }

}