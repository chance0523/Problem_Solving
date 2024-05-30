import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int targetLen = 1;
        
        while (targetLen < len) {
            targetLen *= 2;
        }
        
        int[] answer = new int[targetLen];
        Arrays.fill(answer, 0);
        
        System.arraycopy(arr, 0, answer, 0, len);
        
        return answer;
    }
}
