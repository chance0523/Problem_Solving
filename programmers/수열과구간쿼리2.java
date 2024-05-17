import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];
            int min = 1000001;
            for (int i = s; i <= e; i++) {
                if (arr[i] > k && min > arr[i]) {
                    min = arr[i];
                }
            }
            if (min == 1000001) {
                min = -1;
            }
            answer[j] = min;
        }
        
        return answer;
    }
}
