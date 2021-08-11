class Cell implements Comparable<Cell> {
    int node;
    int time;
    public Cell (int node, int time){
        this.node = node;
        this.time = time;
    }
    public int compareTo (Cell c2){
        return time - c2.time;
    }
}

class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 建图
        // 有向图 所以 把edge的终点和cost加入 此start点的list
        HashMap<Integer, List<Cell>> map = new HashMap<>();
        for(int[] time: times){
            List<Cell> list = map.getOrDefault(time[0], new ArrayList<>());
            list.add(new Cell(time[1], time[2]));
            map.put(time[0], list);
        }
        //创建一个map 用来储存 node  和 cost
        HashMap<Integer, Integer> cost = new HashMap<>();
        // Build a heap and offer the start Node
        PriorityQueue<Cell> q = new PriorityQueue<>();
        q.offer(new Cell(k, 0));
        
        while(!q.isEmpty()){
            //While q not empty poll the nodes out 
            //check it is already been visited skip it
            // if not poll out all its neighbors and add it to queue
            //update the cost 
            
            int qlen = q.size();
            for(int i =0; i < qlen; i++){
                Cell node = q.poll();
                if(cost.containsKey(node.node)){
                    continue;
                }
                cost.put(node.node, node.time);
                if(map.containsKey(node.node)){
                    for(Cell nei : map.get(node.node)){
                        if(!cost.containsKey(nei.node))
                            q.offer(new Cell(nei.node, node.time + nei.time));
                    }
                }
            }
        }
        if(cost.size() != n){
            return -1;
        }
        int res = 0;
        for(int x : cost.values()){
            res = Math.max(x, res);
        }
        return res;
    }
}