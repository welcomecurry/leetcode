class BrowserHistory {

    Stack<String> backward, forward;
    public BrowserHistory(String homepage) {
        backward = new Stack<>();
        forward = new Stack<>();
        backward.push(homepage);
        forward.clear();
    }
    
    public void visit(String url) {
        backward.push(url);
        forward.clear();
    }
    
    public String back(int steps) {
        while(steps-- > 0 && backward.size() > 1){
            forward.push(backward.pop());
        }
        return backward.peek();
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && forward.size() > 0){
            backward.push(forward.pop());
        }
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */