import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        int len = numbers.length;
        answer = numbers[len - 1] * numbers[len - 2];
        return answer;
    }
}
