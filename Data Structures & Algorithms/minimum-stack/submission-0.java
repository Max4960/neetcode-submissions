class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> minimum;

    public MinStack() {
        minStack = new Stack<>();
        minimum = new Stack<>();
        minimum.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        if (val < minimum.peek()) {
            minimum.push(val);
        }
        minStack.push(val);
    }
    
    public void pop() {
        int val = minStack.pop();
        if (val == minimum.peek()) {
            minimum.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}
