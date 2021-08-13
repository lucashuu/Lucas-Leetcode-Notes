//要求 order 所以用heap 来保证 poll 出来永远是 字母顺序order 最小的
//建图 -> Map <Strig, Pq<String> 把和起始点 关联的终点 都加入priority queue 中
//heap 中的 城市 是按 字典的顺序排列的
//从JFK开始 dfs
// 注意是post order 的 回溯顺序 ， 因为 pre-order 会在回溯开始前 对 node 进行更改, 从而一些path 会被直接判死
// 如果post order ， 先回溯 再 更改node 则保证一定会有valid 的路径

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
         HashMap<String, PriorityQueue<String>> map = new HashMap<>();
       
         for(int i = 0; i < tickets.size(); i++){
            PriorityQueue<String> pq = map.getOrDefault(tickets.get(i).get(0), new PriorityQueue<>());
            pq.offer(tickets.get(i).get(1));
             map.put(tickets.get(i).get(0), pq);
            
        }
        //initialize the res list
        List<String> res = new ArrayList<>();
        //Start from JFK dfs
        dfs(res, map,"JFK");
     
        Collections.reverse(res);
        return res;
    }
    public void dfs(List<String> res, HashMap<String, PriorityQueue<String>> map, String node){
        //if the pq size == 0 return
        PriorityQueue<String> pq = map.getOrDefault(node, new PriorityQueue<>());
        if(pq.size() == 0){
            res.add(node);
            return;
        }
        while(!pq.isEmpty()){
                     
                dfs(res, map, pq.poll());

        }
        res.add(node);
        
    }
}