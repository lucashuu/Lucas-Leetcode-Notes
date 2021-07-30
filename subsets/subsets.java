class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        //dfs
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }
    public void dfs(int position, int[] nums){
        res.add(new ArrayList<>(ans));
        if(position >= nums.length){
            return;
        }  
        for(int i = position; i < nums.length; i++){
                ans.add(nums[i]);
                dfs(i + 1, nums);
                ans.remove(ans.size() - 1);
        }
    }
}