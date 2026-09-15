class MinStack {
    Stack<Integer> st;
    Stack<Integer> extra;
    public MinStack() {
        st = new Stack<>();
        extra = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(extra.isEmpty()) extra.push(val);
        else extra.push(Math.min(val, extra.peek()));
    }
    
    public void pop() {
        st.pop();
        extra.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return extra.peek();
    }
}
