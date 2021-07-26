// two pointer 
// one poniter traverse the array
// one pointer put the none duplicates num in array
// 1 1 2
// 1 1
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 1) return nums.length;
        
        int newIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[newIndex]){
                newIndex++;
                nums[newIndex] = nums[i];
            }
        }
        return newIndex + 1;
    }
}