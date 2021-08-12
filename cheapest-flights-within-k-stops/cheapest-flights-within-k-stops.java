
class Cell implements Comparable<Cell> {
    int node;
    int time;
    int stop;
    public Cell (int node, int time, int stop){
        this.node = node;
        this.time = time;
        this.stop = stop;
    }
    
    public int compareTo (Cell c2){
        return this.time - c2.time;
    }
   
    
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Construct Graph 
        HashMap<Integer, List<Cell>> map = new HashMap<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        // Map <Source, List<Cell>> -> Cell (destination , cost , stop);
        for(int[] time : flights){
            List<Cell> edge = map.getOrDefault(time[0], new ArrayList<>());
            edge.add(new Cell(time[1], time[2], -1));
            map.put(time[0], edge);
        }
        PriorityQueue<Cell> q = new PriorityQueue<>();
        // put the start point into the heap
        q.offer(new Cell(src, 0, -1));
        
        // While q is not empty
        // pull out the node and check if stop > k  skip
        // 不用检查去重 因为 题目给了没有cycle 和 K hard constrain 就算有重 走到k的时候也会被排除
        // 如果 node == dstination 则返回current cost/ time
        // 遍历 此 node 所有的 neighbor
        // 把此neighbor 的cost 更新 放入 Heap中
        // 如果没有找到 返回 - 1
        while(!q.isEmpty()){
                     
                Cell node = q.poll();
                System.out.println(node.time );
                if(node.node == dst){
                    return node.time;
                
                }
                if(visited[node.node] <= node.stop || node.stop == k || !map.containsKey(node.node)) continue;
                visited[node.node] = node.stop;
              
                for(Cell nc: map.get(node.node)){
                        q.offer(new Cell(nc.node, nc.time + node.time, node.stop + 1));
                }
                
        }
        
        return -1;
        
    }
}