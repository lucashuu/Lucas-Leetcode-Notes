//由于只需要求整数部分，故对于任意正整数 xx, 
//设其整数部分为 kk, 显然有 1 \leq k \leq x1≤k≤x, 求解 kk 的值也就转化为了在有序数组中查找满足某种约束条件的元素，显然二分搜索是解决此类问题的良方。
class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;

        int lb = 1, ub = x;
        long mid = 0;
        while (lb + 1 < ub) {
            mid = lb + (ub - lb) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                lb = (int)mid;
            } else {
                ub = (int)mid;
            }
        }

        return (int)lb;
    }
}