import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        
        List<Integer> list = new ArrayList<>();
        int[] unique = Arrays.stream(arr).distinct().toArray();
        int len = unique.length;

        for (int i = 0; i < k; i++) {
            if (len > 0) {
                answer[i] = unique[i];
                len--;
            }
            else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
