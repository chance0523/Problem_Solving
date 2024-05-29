import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        int i = 0;
        List<Integer> stk = new ArrayList<>();
        
        while (true) {
            if (i >= arr.length) {
                break;
            }
            if (stk.size() == 0) {
                stk.add(arr[i]);
                i++;
            }
            else {
                int lastIndex = stk.size() - 1;
                if (stk.get(lastIndex) == arr[i]) {
                    stk.remove(lastIndex);
                    i++;
                }
                else {
                    stk.add(arr[i]);
                    i++;
                }
            }
        }
        
        if (stk.size() == 0) {
            stk.add(-1);
            return stk;
        }
        
        return stk;
    }
}
