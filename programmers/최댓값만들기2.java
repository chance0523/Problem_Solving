import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        
        int max = -100000000;
        if (numbers[0] < 0 && numbers[1] < 0) {
            max = numbers[0] * numbers[1];
        }
        
        max = Math.max(max, numbers[len - 1] * numbers[len - 2]);
        
        return max;
    }
}
