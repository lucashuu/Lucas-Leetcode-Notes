class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    int count;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0 || nums == null){
            return null;
        }
        Arrays.sort(nums);
        
        boolean[] used = new boolean[nums.length];
        dfs(nums, used);
        return res;
    }
    public void dfs(int[] nums, boolean[] used){
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                continue;
            }
            ans.add(nums[i]);
            used[i] = true;
            dfs(nums,  used);
            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }
}