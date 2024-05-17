class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return fun2(fun1(x1, x2), fun1(x3, x4));
    }
    
    private boolean fun1(boolean x, boolean y) {
        if (!x && !y) {
            return false;
        }
        return true;
    }
    
    private boolean fun2(boolean x, boolean y) {
        if (x && y) {
            return true;
        }
        return false;
    }
}
