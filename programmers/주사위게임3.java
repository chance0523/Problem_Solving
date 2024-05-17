import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        
        int p = 0;
        int q = 0;
        if (arr[0] == arr[3]) {
            return 1111 * arr[0];
        }
        if (arr[0] == arr[2] || arr[1] == arr[3]) {
            p = arr[1];
            q = arr[0] + arr[3] - arr[1];
            return (10 * p + q) * (10 * p + q);
        }
        if (arr[0] == arr[1] && arr[2] == arr[3]) {
            p = arr[3];
            q = arr[0];
            return (p + q) * (p - q);
        }
        if (arr[0] == arr[1]) {
            return arr[2] * arr[3];
        }
        if (arr[1] == arr[2]) {
            return arr[0] * arr[3];
        }
        if (arr[2] == arr[3]) {
            return arr[0] * arr[1];
        }
        return arr[0];
    }
}
