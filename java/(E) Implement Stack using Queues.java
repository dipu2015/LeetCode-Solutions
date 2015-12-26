class MyStack {
    
    Queue<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<Integer>(queue);
        queue.clear();
        queue.add(x);
        for (int i : temp)
            queue.add(i);
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
