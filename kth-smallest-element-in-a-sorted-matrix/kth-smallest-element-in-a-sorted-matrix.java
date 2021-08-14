class Solution {
    //Heap 
    // traverse the array and matain a max heap with size k return the top elements
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(heap.size() == k ){
                    if(heap.peek() < matrix[i][j]){
                        break;
                    }
                }
                    heap.offer(matrix[i][j]);
                    if(heap.size() > k){
                       heap.poll(); 
                    }
                    
                }
            }
        
        return heap.peek();
    }
}