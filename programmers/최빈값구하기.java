import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int[] counts = new int[array[array.length - 1] + 1];
        
        for(int i=0;i<array.length;i++) {
            counts[array[i]]++;
        }
        
        int common = counts[0];
        int answer = 0;
        for(int i=1;i<counts.length;i++) {
            if (common < counts[i]) {
                common = counts[i];
                answer = i;
            }
            else if (common == counts[i]) {
                answer = -1;
            }
        }
        
        return answer;
    }
}
