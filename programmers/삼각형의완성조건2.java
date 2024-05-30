import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1]; // 긴 변
        for (int i = 1; i <= 2000; i++) {
            if (i >= b && (a + b) > i) {
                answer++;
            }
            if (i < b && (a + i) > b) {
                answer++;
            }
        }
        
        return answer;
    }
}
