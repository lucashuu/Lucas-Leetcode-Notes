class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null){
            return;
        }
        int j = nums.length - 1;
        int i = nums.length - 2;
        boolean find = false;
        while(i >= 0 ){
            if(nums[i] < nums[j]){
        
                break;
            }
            i--;
            j--;
        }
        if(i >= 0){
           
        int k = nums.length - 1;
        while(k >= i){
            if(nums[k] > nums[i]){
                
                break;
            }
            k--;
        }  
        swap(i, k, nums);
        
        }
        reverse(j, nums.length - 1,nums);
        return;
    }
    public void swap(int i, int k, int[] nums){
        System.out.println(i + "" + k);
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
    public void reverse(int start, int end, int[] nums){
        while(start<= end){ //刚刚的算法已经保证j~end是降序排列了，把它们弄成升序只需要头尾交换即可
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}