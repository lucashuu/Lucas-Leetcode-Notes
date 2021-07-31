class Solution {
 
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    //和为target的时候ans 加入res
    //此次combination 可以有重复数据 所以 for 不自增
    //思路基本和combination 一样
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null){
            return res;
        }
        
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return res;
    }
    public void dfs(int pos, int[] nums, int gap){
        if(gap == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            int dif = gap - nums[i];
            if(i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            if(dif >= 0 ){
                ans.add(nums[i]);
                dfs(i + 1, nums, dif);
                ans.remove(ans.size() -1);
            }else{
                continue;
            }
        }
    }
}