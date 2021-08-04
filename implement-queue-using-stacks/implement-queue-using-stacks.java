class MyQueue {
     private Stack<Integer> f;
    private Stack<Integer> s;

    //两个栈 把数据全都 放到一个栈里 
    //再push 到另一个栈里 在pop 就是 先进先出了
    // lIFO -> LIFO  = FIFO
    /** Initialize your data structure here. */
    public MyQueue() {
         f = new Stack<>();
         s = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        f.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s.isEmpty()){
        while(!f.isEmpty()){
            s.push(f.pop());
            }
        }
        return s.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       //如果stack 2 还有 没有pop的优先pop里面的 要不然后面进来的新num 会被先pop出去
    if(s.isEmpty()){
        while(!f.isEmpty()){
            s.push(f.pop());
        }
    }  
        return s.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return f.isEmpty() && s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */