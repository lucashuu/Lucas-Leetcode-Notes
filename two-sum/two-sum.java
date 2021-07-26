//用HashMap
//找不到的时候加入map
//找到的时候返回结果
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[2];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
       
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                int i1 = map.get(target - nums[i]);
                int i2 = i;
                return new int[]{i1, i2};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}