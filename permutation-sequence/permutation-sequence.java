class Solution {
    public String getPermutation(int n, int k) {
        //计算每一位的阶乘
        k--;
        List<Integer> list = new ArrayList<>();
        int[] fact = new int[n];
        // 第一组首元素一定是 1
        fact[0] = 1;
        // 求剩下元素在对于每个 i 情况下的阶乘 n!
        // 事先将 1 2 3 放入 ans
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 1; i < n; i++) {
            // 当 i 是 1，就是 1!
            // 当 i 是 2，就是 2!
            fact[i] = i * fact[i - 1];
        }
        
        StringBuilder sb = new StringBuilder();
        //从后往前 计算k 里面有几个当前的阶乘
        for(int i = n - 1; i >= 0; i--){
            int rank = k / fact[i];
            sb.append(list.get(rank));
            k = k % fact[i];
            list.remove(rank);
        }
        return sb.toString();
    }
}