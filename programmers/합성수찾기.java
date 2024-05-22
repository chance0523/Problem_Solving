class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] arr = new boolean[100001];
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                arr[i*j] = true;
            }
        }
        
        for (int i = 4; i <= n; i++) {
            if (arr[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}
