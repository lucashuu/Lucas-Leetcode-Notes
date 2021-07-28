//后面的元素和前k个元素比较
//如果相等则跳过 如果不相等则则保留 
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return 2;
        }
        // 1 1 1 2 2 2 3
        // 1 1 2
        int newIndex = 1;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[newIndex] || nums[i] != nums[newIndex - 1]){
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }
        return newIndex + 1;
    }
}