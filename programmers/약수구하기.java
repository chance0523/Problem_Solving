import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        
        int size = list.size();
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
